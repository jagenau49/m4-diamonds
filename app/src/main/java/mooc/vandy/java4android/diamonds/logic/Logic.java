package mooc.vandy.java4android.diamonds.logic;

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {
        // TODO -- add your code here
        int totalLine=size*2+1;


        /*for (int actualLine=0; actualLine<totalLine;actualLine++){
            if(actualLine==0 || actualLine==totalLine-1){
                mOut.println(upOrBottomLine(size));//Upper Line
            }else if(actualLine==1||actualLine==totalLine-2){

            }
        };*/


        
    }

    // TODO -- add any helper methods here
    public String upOrBottomLine(int size){
        String middleLine="";
        for (int i=0; i<(size*2);i++){
            middleLine=middleLine.concat("-");
        };
        return "+"+middleLine+"+";

    }
    public String line1(int size){
        int rowWidth=(size*2)+2;
        String middleLine="";
        int locationOfSlash=size;
        int locationOfBackslash=size+1;
        for(int j=1;j<rowWidth-1;j++){
            if(j==locationOfSlash){
                middleLine=middleLine.concat("/");

            }else if(j==locationOfBackslash){
                middleLine=middleLine.concat("\\");
            }else{
           middleLine=middleLine.concat(" ");

        };
        };
        return "|"+middleLine+"|";

    };

    
}
