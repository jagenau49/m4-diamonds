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
        int rowWidth=size*2+2;
        int totalLine=size*2+1;

        //Test basi
        for (int lineNumber=0;lineNumber <totalLine;lineNumber++){
            if (lineNumber==0||lineNumber==totalLine-1){
                mOut.println(upOrBottomLine(size));
            }else if(lineNumber==1||lineNumber==totalLine-2){
                mOut.println(lineFirstOrLast(size,lineNumber,rowWidth));
            }else{
                mOut.println(oddOrEvenLine(size,lineNumber,rowWidth));
            }
        }


        //Test sonu


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
    public String lineFirstOrLast(int size, int actualLine, int rowWidth){

        String middleLine="";
        int locationOfSlash,locationOfBackslash;
        if (actualLine==1) {
            locationOfSlash = size;
            locationOfBackslash = size + 1;
        }else{
            locationOfSlash = size+1;
            locationOfBackslash = size;
        }
        for(int j=1;j<rowWidth-1;j++){
            if(j==locationOfSlash){
                middleLine=middleLine.concat("/");

            }else if(j==locationOfBackslash){
                middleLine=middleLine.concat("\\");
            }else{
           middleLine=middleLine.concat(" ");

        };
        };
        if (size==1){
            return "|<>|";
        }else {
            return "|" + middleLine + "|";
        }

    };
    public String oddOrEvenLine(int size, int actualLine, int rowWidth){
        String fillingChar=null;
        String middleFilling="";
        int locationOfBackslash,locationOfSlash;

        if (actualLine>size){
             locationOfBackslash  =actualLine -size + 1;
             locationOfSlash = rowWidth - locationOfBackslash - 1;

        }else {

             locationOfSlash = size - actualLine + 1;
             locationOfBackslash = rowWidth - locationOfSlash - 1;
        }


        if(actualLine%2==0){//even Line: '-'
fillingChar="-";
        }else{ //odd Line:'='
            fillingChar="=";
        };
        for (int t=1;t<rowWidth-1;t++){
            if(t==locationOfSlash){
                if(actualLine==size) {//middle line
                    middleFilling=middleFilling.concat("<");
                }else{
                middleFilling=middleFilling.concat("/");}

            }else if(t==locationOfBackslash){
                if(actualLine==size) {//middle line
                    middleFilling=middleFilling.concat(">");
                }else{
                    middleFilling=middleFilling.concat("\\");}
            }else if(actualLine<=size&&t>locationOfSlash&&t<locationOfBackslash) {
                middleFilling=middleFilling.concat(fillingChar);
            }else if (actualLine>size&&t<locationOfSlash&&t>locationOfBackslash){
                middleFilling=middleFilling.concat(fillingChar);
        }else{
                middleFilling=middleFilling.concat(" ");

            };

        };


                return "|"+middleFilling+"|";

    };

    
}
