import ch.heg.ig.sda.datastructure.tree.LinkedGeneralTree;
import ch.heg.ig.sda.datastructure.tree.Position;
import org.artirev.fuzsim.LevDistReferenceSimilarity;
import org.artirev.fuzsim.ReferenceSimilarity;
import org.artirev.io.DocumentsCsvDatabaseLoader;

public class Main {
    private static final String filepath = "C:\\HEG\\SDA\\SDA_Serie12_AlgComplexity\\SDA_Serie12_AlgComplexity\\data\\bibliometric_top20_scopus_export.csv";


    public static void main(String[] args) {

        // Préambule
        // countPrimitiveOperations();

        // Exemple 1 : comparaison de chaines de caractères
        calculateStringDistance(filepath);

        // Exemple 2 : récursivité
        // treeHeight();
    }


    private static void countPrimitiveOperations() {
        System.out.println("\nCOUNT PRIMITIVE OPERATIONS");

        StringBuilder stringBuilder = new StringBuilder();

        // Cas 1 - Pire cas
        Integer[] numbers = new Integer[7];
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        numbers[3] = 4;
        numbers[4] = 5; // max
        numbers[5] = 6; // max
        numbers[6] = 7; // max

        stringBuilder.append("\nArray ");
        stringBuilder.append("(n=");
        stringBuilder.append(numbers.length);
        stringBuilder.append(") : ");

        for (int i = 0; i < numbers.length; i++) {
            stringBuilder.append(numbers[i]);
            if (i < numbers.length - 1)
                stringBuilder.append(", ");
        }

        System.out.println(stringBuilder.toString());
        System.out.println("Max : " + getMax(numbers, true));


        // Cas 2 - Meilleur cas
        stringBuilder = new StringBuilder();

        numbers[0] = 5; // max
        numbers[1] = 4;
        numbers[2] = 3;
        numbers[3] = 2;
        numbers[4] = 1;

        stringBuilder.append("\nArray ");
        stringBuilder.append("(n=");
        stringBuilder.append(numbers.length);
        stringBuilder.append(") : ");

        for (int i = 0; i < numbers.length; i++) {
            stringBuilder.append(numbers[i]);
            if (i < numbers.length - 1)
                stringBuilder.append(", ");
        }

        System.out.println(stringBuilder.toString());
        System.out.println("Max : " + getMax(numbers, true));
    }


    private static int getMax(Integer[] numbers, boolean countOperations) {
        int primitiveOperationsCounter = 0;

        int max = numbers[0]; // primitive operations

        if (countOperations)
            primitiveOperationsCounter++; // meilleur cas et pire cas = 1

        for (int i = 1; i < numbers.length; i++) {

            if (countOperations)
                primitiveOperationsCounter++; // meilleur cas et pire cas = n-1

            if (numbers[i] > max) {
                max = numbers[i];

                if (countOperations)
                    primitiveOperationsCounter++; // meilleur cas = 0, pire cas = n-1
            }
        }

        System.out.println("Numbers of primitive operations : " + primitiveOperationsCounter);

        return max;
    }

    // Without debug
    private static int getMax(Integer[] numbers) {
        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        return max;
    }

    private static void treeHeight() {
        System.out.println("\nTREE HEIGHT (n2)");
        LinkedGeneralTree<Integer> tree = new LinkedGeneralTree<>();

        Position<Integer> position = tree.addRoot(0);

        for (int i = 1; i < 10; i++) {
            position = tree.addChild(position, i);
        }
        System.out.println(tree.toStringPreorder());

        long startTime = System.currentTimeMillis();
        int height = tree.height(tree.root());
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Tree height : " + height + " in " + elapsedTime + "ms");

        startTime = System.currentTimeMillis();
        int heightBad = tree.heightBad(tree.root());
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;

        System.out.println("Tree height (bad) : " + heightBad + " in " + elapsedTime + "ms");

    }

    private static void calculateStringDistance(String filepath) {

        System.out.println("\nCalculateStringDistance...");

        // Charge les données en mémoire
        DocumentsCsvDatabaseLoader loader = new DocumentsCsvDatabaseLoader(filepath);
        loader.process();

        ReferenceSimilarity referenceSimilarity = new LevDistReferenceSimilarity();
        long startTime = System.currentTimeMillis();
        referenceSimilarity.computeDistances(loader.getDocuments(), 3);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Calculation finished.");
        System.out.println("Duration : " + elapsedTime + "ms");

    }

}