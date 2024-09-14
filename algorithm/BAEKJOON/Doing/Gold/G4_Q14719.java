package Doing.Gold;

import java.util.Scanner;

/**
 * 14719 빗물
 * 골드Ⅴ
 */
public class G4_Q14719 {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int h = scan.nextInt(), w = scan.nextInt();

            int[] block = new int[w];
            for(int i=0; i<w; i++) {
                block[i] = scan.nextInt();
            }

            int[][] box = new int[h][w];
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    box[i][j] = j;
                }
            }

            // run(block, box);
            answer(block, box);
        }
    }

    static void answer(int[] block, int[][] box) {
        int start = 0, end = 0;
        int sum = 0;
        for(int i=0; i<block.length; i++) {
            if(start <= block[i]) {
                start = block[i];
            } else {
                System.out.println("S : "+start+" B :"+block[i]);
                sum += start - block[i];
            }
        }

        System.out.println(sum);
    }

    static void run(int[] block, int[][] box) {
        for(int i=0; i<box.length; i++) {

            // System.out.println("box[i].length : "+ box[i].length +" block[i] : " + block[i] + " M : "+ (box[i].length - block[i]));
            for(int j=0; j<box[i].length; j++) {
                int x = box.length;

                if(((x-i) - block[j]) > 0) {
                    System.out.print("□ ");
                } else {
                    System.out.print("■ ");
                }
            }
            System.out.println();
        }
    }
}
