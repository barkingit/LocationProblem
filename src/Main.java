import java.util.LinkedList;

public class Main {


    public static void main(String[] args) {
        String[] array1 = {"Cologne","Berlin"};
        String[] array2 = {"Munich", "Cologne"};
        String[] array3 = {"YourPlace", "Munich"};

        String[][] arrays = new String[][]{array1, array2, array3};

        Object[] arrayReturn = returnInOrder(arrays);

        for (int i = 0; i < arrayReturn.length; i++) {
            System.out.print(arrayReturn[i] + "->");
        }

        System.out.print("END");
    }

    public static Object[] returnInOrder(String[][] arrays) {
        LinkedList<String> linkedList = new LinkedList();

        for (String[] array : arrays) {
            String left = array[0];
            String right = array[1];

            if (linkedList.contains(left)) {
                int leftPlace = linkedList.indexOf(left);
                linkedList.add(leftPlace + 1, right);
            } else if (linkedList.contains(right)) {
                int rightPlace = linkedList.indexOf(right);
                int newPlace = rightPlace - 1;

                if (newPlace < 0) {
                    linkedList.addFirst(left);
                } else {
                    linkedList.add(rightPlace - 1, right);
                }

            } else {
                linkedList.add(left);
                linkedList.add(right);
            }

        }
        return linkedList.toArray();


    }
}
