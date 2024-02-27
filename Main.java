import java.util.*;

//Question 1
class SortArray{
    //primary data structure for wrapper class
    ArrayList<Double> list= new ArrayList<>();
    //inserts multiple elements to the array at once
    public void add(Double[] elements){
        for(int i=0;i< elements.length;i++){
            list.add(elements[i]);
        }
        list.sort(null);
    }
    //inserts a single element into the array
    public void add(Double element){
        list.add(element);
        list.sort(null);
    }
    //prints out the array's length
    public void print(){
        System.out.println("The size of the array is " + list.size()+" elements.");
    }
    // returns the value of the array at a specific index
    public Object getElement(int location){
        return list.get(location);
    }
    // sets the value of the array at a specific index.
    // returns the index where the value was inserted on success
    // returns -1 on failure
    public int setElement(int location, Double replacement){
        if(location >= list.size() || location < 0){
            return -1;
        }
        list.set(location, replacement);
        return location;
    }
    // removes an element from the array at a specified index
    public void removeElement(int location){
        list.remove(location);
    }
    // returns whether or not the array is empty
    public boolean checkEmpty(){
        return list.isEmpty();
    }
    // allows us to print out the array using System.out.println
    public String toString(){
        String output = "[";
        for(int i = 0; i < list.size(); i++){
            output = output + list.get(i);
            if (list.size()-i > 1){
                output = output + ", ";
            }
        }
        return output + "]";
    }
    //Question 3 extending from Question1
    //Finds the median average of the array
    //In the event of an even number of elements, the average of the two centers is returned
    public Double medianMethod() {
        if (checkEmpty()){
            return 0.0;
        }
        if (list.size() % 2 == 0) {
            int lowerBound= list.size()/2;
            int upperBound= lowerBound +1;
            return (list.get(lowerBound)+list.get(upperBound))/2;
        }
        else {
            return list.get(list.size() / 2);
        }
    }
}
//Question 5
//Functional Interface for question 5
//This is to allow passing a lambda function for the traversal
@FunctionalInterface
interface Function{
    void apply(Object o);
}
//Custom array wrapper class (unsorted)
class MyArray{
    //primary data storage structure for wrapper
    ArrayList<Object> list= new ArrayList<Object>();
    // constructor to build the array wrapper from any List-like structure
    public MyArray(List<Object> collect){
        for(int i=0;i< collect.size();i++){
            list.add(collect.get(i));
        }
    }

    // returns the size of the array
    public int getSize(){
        return list.size();
    }

    // returns the value of the array at a specific index
    public Object getIndex(int index){
        return list.get(index);
    }

    // sets the value of the array at a specific element
    // returns true or false for success or failure respectively
    public boolean setIndex(int index, Object replacement){
        if(index<list.size()&&index>-1){
            list.set(index,replacement);
            return true;
        }else {
            System.out.println("Index out of Bounds");
            return false;
        }
    }

    // inserts a value onto the end of the array
    public void insertValue(Object value){
        list.add(value);
    }

    // returns the index of a specific element in the array
    // returns -1 if the element does not exist
    public int findObject(Object value){
        for (int i=0; i<list.size(); i++){
            if(value.equals(list.get(i))){
                return i;
            }
        }
        return -1;
    }

    // finds the value of a specific element in the array
    // if the value is in the array, the value is returned
    // otherwise, "Value not found" is returned.
    public Object searchObject(Object value){
        for (int i=0; i<list.size(); i++){
            if(value.equals(list.get(i))){
                return list.get(i);
            }
        }
        return "Value not found";
    }

    // removes an element from the array as specified by the value of the object
    // only removes the first matching object
    // returns true or false depending on whether an object was deleted or not
    public boolean deleteObject(Object toBeDeleted){
        for (int i=0; i<list.size(); i++){
            if(toBeDeleted.equals(list.get(i))){
                list.remove(i);
                return true;
            }
        }
        return false;
    }
    // loops through every element in the list and applies a lambda function to each one
    public void traverseList(Function func){
        for (int i = 0; i < list.size(); i++){
            func.apply(list.get(i));
        }

    }
}
public class Main {
    //Question 2
    public static String reverseWord(String word){
        String output = "";
        for(int i = word.length(); i >0 ; i--){
            output=output+word.charAt(i-1);
        }
        return output;
    }
    //Question 4
    public static void oddEvenSort(Double[] arr){
        boolean sorted = false;
        // continue until fully sorted
        while (!sorted) {
            // keep going until a loop over the array makes no further swaps
            sorted = true;
            double placeHolder = 0;
            //odd bubble process
            for (int i = 1; i <= arr.length - 2; i = i + 2) {
                if (arr[i] > arr[i + 1]) {
                    placeHolder = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = placeHolder;
                    sorted = false;
                }
            }
            //even bubble process
            for (int i = 0; i <= arr.length - 2; i = i + 2) {
                if (arr[i] > arr[i + 1]) {
                    placeHolder = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = placeHolder;
                    sorted = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        //***************** DEMONSTRATION CODE CREATED USING GENERATIVE AI ********************
        //test for Question1
        System.out.println("========Testing Question 1========");
        Scanner scanner = new Scanner(System.in);

        // Create an instance of SortArray
        SortArray sortArray = new SortArray();

        // Read input for array elements
        System.out.println("Enter elements to add to the array (type 'done' when finished):");
        ArrayList<Double> inputElements = new ArrayList<>();
        while (true) {
            try {
                String input = scanner.nextLine();
                if (input.equals("done")) {
                    break;
                }
                double value = Double.parseDouble(input);
                inputElements.add(value);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'done' to finish.");
            }
        }

        // Convert ArrayList to array and add to SortArray
        Double[] elementsToAdd = new Double[inputElements.size()];
        inputElements.toArray(elementsToAdd);
        sortArray.add(elementsToAdd);

        // Print the size of the array
        sortArray.print();
        // Print the array
        System.out.println(sortArray);

        // Test getElement method
        try {
            System.out.println("Enter location to get element:");
            int location = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            System.out.println("Element at location " + location + ": " + sortArray.getElement(location));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid location.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for location.");
            scanner.nextLine();
        }

        // Test setElement method
        try {
            System.out.println("Enter location and value to set:");
            int setLocation = scanner.nextInt();
            double replacement = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character
            int result = sortArray.setElement(setLocation, replacement);
            if (result != -1) {
                System.out.println("Element at location " + setLocation + " set to " + replacement);
            } else {
                System.out.println("Invalid location.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.nextLine();
        }

        // Test removeElement method
        try {
            System.out.println("Enter location to remove element:");
            int removeLocation = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            sortArray.removeElement(removeLocation);
            System.out.println("Element at location " + removeLocation + " removed.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid location.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for location.");
            scanner.nextLine();
        }

        // Test checkEmpty method
        System.out.println("Array is empty: " + sortArray.checkEmpty());
        //test for Question2
        System.out.println("Array values: ");
        System.out.println(sortArray);
        System.out.println("========Testing Question 2========");
        System.out.print("Input a word to reverse: ");
        Scanner myScan= new Scanner(System.in);
        String wordToReverse = myScan.nextLine();
        System.out.println("The reversed word is "+ reverseWord(wordToReverse)+".");
        //Test for Question3
        System.out.println("========Testing Question 3========");
        // Create an instance of SortArray
        sortArray = new SortArray();

        // Read input for array elements
        System.out.println("Enter elements to add to the array (type 'done' when finished):");
        inputElements = new ArrayList<>();
        while (true) {
            try {
                String input = scanner.nextLine();
                if (input.equals("done")) {
                    break;
                }
                double value = Double.parseDouble(input);
                inputElements.add(value);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'done' to finish.");
            }
        }

        // Convert ArrayList to array and add to SortArray
        elementsToAdd = new Double[inputElements.size()];
        inputElements.toArray(elementsToAdd);
        sortArray.add(elementsToAdd);

        // Calculate and print the median
        System.out.println("Median: " + sortArray.medianMethod());
        //Test for Question4
        System.out.println("========Testing Question 4========");
        // Generate random array of Doubles
        Double[] arr = new Double[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextDouble() * 100; // Generate random double between 0 and 100
        }

        // Print unsorted array
        System.out.println("Unsorted array:");
        System.out.println(Arrays.toString(arr));

        // Sort array using oddEvenSort
        oddEvenSort(arr);

        // Print sorted array
        System.out.println("\nSorted array:");
        System.out.println(Arrays.toString(arr));
        //Test for Question5
        System.out.println("========Testing Question 5========");
        // Read input from the user to create a list of Doubles
        // NOTE: THE ARRAY IS ACCEPTING OF MORE THAN JUST DOUBLE TYPES, HOWEVER THIS
        // IS USED AS A SIMPLE TEST FOR DEMONSTRATING THE FUNCTIONALITY.
        System.out.println("Enter elements (type 'done' to finish):");
        List<Object> elements = new ArrayList<>();
        while (true) {
            try {
                String input = scanner.nextLine();
                if (input.equals("done")) {
                    break;
                }
                double value = Double.parseDouble(input);
                elements.add(value);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'done' to finish.");
            }
        }

        // Create a MyArray object
        MyArray myArray = new MyArray(elements);

        // Test each method
        System.out.println("Size of the array: " + myArray.getSize());

        try {
            System.out.println("Enter index to get value:");
            int index = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            System.out.println("Value at index " + index + ": " + myArray.getIndex(index));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index.");
        } catch (InputMismatchException e){
            System.out.println("Invalid Input");
            scanner.nextLine();
        }

        System.out.println("Enter index and replacement value to set:");
        try {
            int setIndex = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            double replacement = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character
            boolean setResult = myArray.setIndex(setIndex, replacement);
            if (setResult) {
                System.out.println("Set operation successful.");
            } else {
                System.out.println("Set operation failed. Index out of bounds.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.nextLine();
        }

        System.out.println("Enter value to insert:");
        try {
            double insertValue = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character
            myArray.insertValue(insertValue);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for insertion value.");
            scanner.nextLine();
        }

        System.out.println("Enter value to find its index:");
        try {
            double findValue = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character
            System.out.println("Index of " + (int) findValue + ": " + myArray.findObject(findValue));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for search value.");
            scanner.nextLine();
        }

        System.out.println("Enter value to search:");
        try {
            double searchValue = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character
            System.out.println("Search result: " + myArray.searchObject(searchValue));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for search value.");
            scanner.nextLine();
        }

        System.out.println("Enter value to delete:");
        try {
            double deleteValue = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character
            System.out.println("Deletion result: " + myArray.deleteObject(deleteValue));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for deletion value.");
            scanner.nextLine();
        }

        System.out.println("Array after deletion:");
        myArray.traverseList((Function) o -> System.out.println(o)); // Using lambda function with Function interface
        //***************** END OF AI GENERATED CODE ********************
    }
}