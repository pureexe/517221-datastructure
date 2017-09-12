package week2;

/**
 *
 * @author pakkapon phongthawee (07580028)
 */
public class RowFullFill {
    public static boolean isFillVertical(int[][] maps,int y)
    {
        int i;
        for(i=0;i<5;i++){
            if(maps[i][y] == 0){
                return false;
            }
        }
        return true;
    }
    public static boolean isFillHorizontal(int[][] maps,int x)
    {
        int i;
        for(i=0;i<5;i++){
            if(maps[x][i] == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        int i,j,randX,randY,count = 0;
        int[][] maps = new int[5][];
        for(i=0;i<5;i++){
           maps[i] = new int[5];
           for(j=0;j<5;j++){
               maps[i][j] = 0;
           }
        }
        while(true){
            randX = (int)(Math.random()*5);
            randY = (int)(Math.random()*5);
            if(maps[randX][randY] != 0){
                continue;
            }
            maps[randX][randY] = 1;
            System.out.print("("+randX+","+randY+") ");
            if(++count % 10 == 0){
                System.out.println('\n');
            }
            if(isFillVertical(maps,randY) || isFillHorizontal(maps,randX)){
                break;
            }
        }
        System.out.print('\n');
        for(i = 0;i < 5; i++){
            for(j = 0; j < 5; j++){
                System.out.print(maps[i][j] + " ");
            }
            System.out.print('\n');
        }
    }
}
