
class Ejecutable {
    public static void main(String[] args) {
        Zoologico zoo = new Zoologico();

        Mamifero leon = new Mamifero("Simba", 5, "Carnívoro", "Carne", 190.5, 1.2, "sano", "Sabana", "Dorado");
        Reptil serpiente = new Reptil("Kaa", 3, "Carnívoro", "Ratones", 15.0, 3.5, "sano", "Selva", "Escamas lisas");
        Ave aguila = new Ave("Zeus", 4, "Carnívoro", "Peces", 6.5, 0.9, "sano", "Montaña", 2.3);

        zoo.agregarAnimal(leon);
        zoo.agregarAnimal(serpiente);
        zoo.agregarAnimal(aguila);

        Cuidador cuidador1 = new Cuidador("Carlos", 35, "Mamíferos");
        Cuidador cuidador2 = new Cuidador("Ana", 28, "Reptiles");

        cuidador1.asignarAnimal(leon);
        cuidador2.asignarAnimal(serpiente);

        zoo.agregarCuidador(cuidador1);
        zoo.agregarCuidador(cuidador2);

        Visitante visitante1 = new Visitante("Pedro", 25);
        Visitante visitante2 = new Visitante("Maria", 30);

        zoo.agregarVisitante(visitante1);
        zoo.agregarVisitante(visitante2);

        zoo.mostrarAnimales();
        zoo.mostrarCuidadores();

        System.out.println("\n=== INTERACCIONES ===");
        cuidador1.alimentar(leon);
        cuidador1.banar(leon);
        cuidador2.limpiarHabitat(serpiente);

        visitante1.agregarAnimalFavorito(leon);
        visitante1.tomarFotografia(leon);
        visitante1.darPropina(cuidador1, 5000);

        visitante2.agregarAnimalFavorito(aguila);
        visitante2.alimentarAnimal(aguila);
    }
}