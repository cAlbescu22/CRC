import java.util.Scanner;

public class Cripting {
    public static void main(String[] args) {
        int n;
        Scanner scan=new Scanner(System.in);
        System.out.println("Size of the data: ");
        n=scan.nextInt();
        int data[]=new int[n];
        System.out.println("Enter the data: ");
        for (int i = 0; i <n; i++) {
            data[i] = scan.nextInt();
        }
        System.out.println("Size of the divisor: ");
        n=scan.nextInt();
        int divisor[]=new int[n];
        System.out.println("Enter the divisor: ");
        for (int i = 0; i <n ; i++) {
            divisor[i]=scan.nextInt();

        }
        int remainder[]= divide(data,divisor);
        System.out.print("CRC: ");
        for (int i = 0; i <data.length ; i++) {
            System.out.print(data[i]);
        }
        for (int i = 0; i <remainder.length-1 ; i++) {
            System.out.print(remainder[i]);
        }



    }
    static int[] divide(int old_data[],int divisor[]){
        int remainder[];
        int data[]=new int[old_data.length+divisor.length];
        System.arraycopy(old_data,0,data,0,old_data.length);
        remainder=new int[divisor.length];
        System.arraycopy(data,0,remainder,0,divisor.length);
        for (int i = 0; i <old_data.length ; i++) {
            if (remainder[0]==1){
                for (int j = 1; j <divisor.length ; j++) {
                    remainder[j-1]=exor(remainder[j],divisor[j]);
                }
            }
            remainder[divisor.length-1]=data[i+divisor.length];

        }
        return remainder;
    }
    static int exor(int a,int b){
        if (a==b){
            return 0;
        } else
        return 1;
    }
}
