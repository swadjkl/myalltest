public class SystemTest {
    public static void main(String[] args){
        int[] array = {1,2,3};
        int[] arrayNew = new int[array.length*2];
        System.arraycopy(array,0,arrayNew,0,array.length);
        array = arrayNew;
        for(int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
}
