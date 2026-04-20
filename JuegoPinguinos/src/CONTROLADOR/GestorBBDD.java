package CONTROLADOR;

import MODELO.Partida;
import MODELO.Pinguino;

import java.sql.*;
import java.util.ArrayList;

public class GestorBBDD {

    private final String url, user, pass;
    private Connection con;

  
    public GestorBBDD() {
        this.url  = "jdbc:oracle:thin:@192.168.3.26:1521/XEPDB2";
        this.user = "DM1_2526_GRUP05";
        this.pass = "AGRUP05";
    }
    
    // ── CONEXIÓN ──────────────────────────────────────────

    public boolean conectar() {
        try {
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión exitosa");
            return true;
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
            return false;
        }
    }

    public void desconectar() {
        try {
            if (con != null && !con.isClosed()) con.close();
        } catch (SQLException e) {
            System.err.println("Error al cerrar: " + e.getMessage());
        }
    }

    // ── GUARDAR ───────────────────────────────────────────

    public int guardarBBDD(Partida p) {
        int id = -1;
        try {
            // Insertar partida
            con.createStatement().executeUpdate(
                "INSERT INTO PARTIDAS (id, tamanyo_tablero, turno_actual) " +
                "VALUES (SEQ_PARTIDAS.NEXTVAL, " + p.getTablero().getTamaño() + ", 0)"
            );

            // Obtener ID generado
            ResultSet rs = con.createStatement()
                .executeQuery("SELECT SEQ_PARTIDAS.CURRVAL FROM DUAL");
            if (rs.next()) id = rs.getInt(1);

            // Insertar pingüinos
            for (Pinguino pg : p.getJugadores()) {
                guardarPinguino(pg, id);
            }

            System.out.println("Partida guardada con ID: " + id);
        } catch (SQLException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
        return id;
    }

    private void guardarPinguino(Pinguino pg, int idPartida) throws SQLException {
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO PINGUINOS (id, id_partida, nombre, color, puntuacion) " +
            "VALUES (SEQ_PINGUINOS.NEXTVAL, ?, ?, ?, ?)"
        );
        ps.setInt(1, idPartida);
        ps.setString(2, pg.getNombre());
        ps.setString(3, pg.getColor());
        ps.setInt(4, pg.getPuntuacion());
        ps.executeUpdate();
    }

    // ── CARGAR ────────────────────────────────────────────

    public Partida cargarBBDD(int id) {
        try {
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM PARTIDAS WHERE id = ?"
            );
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Partida partida = new Partida(rs.getInt("tamanyo_tablero"));
                int turno = rs.getInt("turno_actual");

                for (Pinguino pg : cargarPinguinos(id))
                    partida.añadirJugador(pg);

                for (int i = 0; i < turno; i++)
                    partida.siguienteTurno();

                System.out.println("Partida " + id + " cargada");
                return partida;
            }
        } catch (SQLException e) {
            System.err.println("Error al cargar: " + e.getMessage());
        }
        return null;
    }

    private ArrayList<Pinguino> cargarPinguinos(int idPartida) throws SQLException {
        ArrayList<Pinguino> lista = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM PINGUINOS WHERE id_partida = ? ORDER BY id"
        );
        ps.setInt(1, idPartida);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
            lista.add(new Pinguino(rs.getString("nombre"), rs.getString("color")));

        return lista;
    }
}

