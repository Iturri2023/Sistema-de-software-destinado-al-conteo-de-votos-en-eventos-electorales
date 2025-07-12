package javaapplication12;

/**
 *
 * @author TEC GAMER
 */
public class SISTEMA {

//esto es una prueba
    public static void main(String[] args) {
    // 1. Crear un partido político
        PartidoPolitico pp1 = new PartidoPolitico("Partido Unidad Nacional", "PUN", "logo_pun.png", "Juan Perez");
        pp1.registrar(); // 

        // 2. Crear candidatos
        Candidato c1 = new Candidato("Maria", "Gonzales", "12345678", pp1);
        c1.registrar(); // 
        Candidato c2 = new Candidato("Carlos", "Ramirez", "87654321", pp1);
        c2.registrar();

        // 3. Crear una elección
        Eleccion eleccionNacional2025 = new Eleccion("ELECC001", "2025-10-26", "nacional");
        eleccionNacional2025.registrar(); // 

        // 4. Asignar candidatos a la elección
        eleccionNacional2025.agregarCandidato(c1);
        eleccionNacional2025.agregarCandidato(c2);

        // 5. Crear miembros de mesa
        MiembroDeMesa mdm1 = new MiembroDeMesa("Ana", "Lopez", "presidente");
        mdm1.registrar(); // 
        MiembroDeMesa mdm2 = new MiembroDeMesa("Pedro", "Gomez", "secretario");

        // 6. Crear una mesa electoral y asignar miembros
        MesaElectoral mesa101 = new MesaElectoral("MESA101", "Escuela #5");
        mesa101.registrar(); // 
        mesa101.asignarMiembro(mdm1); // 
        mesa101.asignarMiembro(mdm2);
        eleccionNacional2025.agregarMesaElectoral(mesa101);

        // 7. Registrar un acta de votos para la mesa
        // Se asume que los candidatos en la eleccion estan en un orden conocido para 'resultadosPorCandidato'
        RegistroDeActas actaMesa101 = new RegistroDeActas(
            "Acta de Votación Nacional", "2025-10-26", "18:00",
            "Escuela #5", "MESA101", 200, 190, 2 // 2 candidatos
        );
        actaMesa101.agregarMiembroPresente(mdm1); // Miembros que firman el acta
        actaMesa101.agregarMiembroPresente(mdm2);

        actaMesa101.registrarVotos(0, 100); // 100 votos para el candidato 0 (Maria Gonzales) 
        actaMesa101.registrarVotos(1, 80);  // 80 votos para el candidato 1 (Carlos Ramirez)
        actaMesa101.setVotosEnBlanco(5);
        actaMesa101.setVotosNulos(5);
        actaMesa101.setObservaciones("Ninguna");
        actaMesa101.setFirmas(true);
        actaMesa101.setSelloOficial(true);

        System.out.println("\nResumen del Acta " + actaMesa101.numeroActaUnico);
        System.out.println("Votos para candidato 0: " + actaMesa101.getResultadosPorCandidato()[0]);
        System.out.println("Votos para candidato 1: " + actaMesa101.getResultadosPorCandidato()[1]);
        System.out.println("Votos en blanco: " + actaMesa101.votosEnBlanco);
        System.out.println("Votos nulos: " + actaMesa101.votosNulos);

        // Simular autenticación de operador
        Operador op1 = new Operador("admin", "pass123");
        if (op1.autenticar("admin", "pass123")) { // 
            System.out.println("\nOperador autenticado exitosamente.");
        } else {
            System.out.println("\nFallo en la autenticación del operador.");
        }
    }
    
    
    }
    

