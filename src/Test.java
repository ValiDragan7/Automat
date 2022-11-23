public class Test {
    public static void main(String args[]) throws Exception {
        Automat M = new Automat("D:/Java/Automat/src/automat.txt");
        // System.out.println(M.analizeazaCuvant("abba"));
        // M.Determinist();
        M.cale("q0", "q2");
    }
}