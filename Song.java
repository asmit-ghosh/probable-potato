import java.util.Arrays;
import java.util.Scanner;

public class cpa12june {
    public static void main(String[] args) {
        Song[] songs=new Song[5];
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i <songs.length ; i++) {
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            double d=sc.nextDouble();
            sc.nextLine();
            songs[i]=new Song(a,b,c,d);
        }
        String input1=sc.nextLine();
        String input2=sc.nextLine();

          double ans1=findSongDurationForArtist(songs,input1);
          if(ans1==0)
          {
              System.out.println("There is no songs with given artist");
          }
          else
          {
              System.out.println(ans1);
          }

        Song[] ans2=  getSongsInAscendingOrder(songs,input2);
          if(ans2==null)
          {
              System.out.println("There are no songs with given artist");
          }
          else
          {
              for (int i = 0; i <ans2.length ; i++) {
                  System.out.println(ans2[i].songId);
                  System.out.println(ans2[i].title);
              }
          }

    }


    public static double findSongDurationForArtist(Song[] songs,String input1)
    {
        double sum=0;
        int count=0;
        for (int i = 0; i <songs.length ; i++) {
            if(songs[i].artist.equalsIgnoreCase(input1))
            {
                count=count+1;
                sum=sum+songs[i].duration;
            }
        }
        if(count>0)
        {
            return sum;
        }
    return 0;


    }





    public static Song[] getSongsInAscendingOrder(Song[] songs,String input2)
    {
        Song[] help=new Song[0];
        for (int i = 0; i <songs.length ; i++) {
            if(songs[i].artist.equalsIgnoreCase(input2))
            {
                help= Arrays.copyOf(help,help.length+1);
                help[help.length-1]=songs[i];
            }
        }

        //bubble sort
        for (int i = 0; i <help.length-1 ; i++) {
            for (int j = 0; j <help.length-i-1 ; j++) {
                if(help[j].duration>help[j+1].duration)
                {
                    Song temp=help[j];
                    help[j]=help[j+1];
                    help[j+1]=temp;
                }
            }
        }

        if(help.length>0)
        {
            return help;
        }

        return null;
    }


}




class Song
{
    int songId;
    String title;
    String artist;
    double duration;

    //parametrized constructor


    public Song(int songId, String title, String artist, double duration) {
        this.songId = songId;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
}
