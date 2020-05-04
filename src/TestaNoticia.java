public class TestaNoticia {

    public static void main(String[] args) {
        JornalistaProfissional j1 = new JornalistaProfissional();
        j1.setNome("Cid Bobeira");

        Noticia n1 = new Noticia();
        n1.setJornalista(j1);

        JornalistaTrainee j2 = new JornalistaTrainee();
        j2.setNome("Trainee Bobeira");

        Noticia n2 = new Noticia();
        n2.setJornalista(j2);
    }

}
