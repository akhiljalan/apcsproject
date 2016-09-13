/*
 * represents a seat object
 * used by customers to represent the seats they have booked
 * used by plane in a twoD array
 */
public class Seat
{
    private String eLabel;
    private boolean eBought; 
    private int erow, ecol; 
    private String edeparture, edestination; 
    private Date ewhenLeaving; 
    public Seat(boolean Bought, int row, int col)
    {
        //eLabel = Label;
        eBought = Bought; 
        erow = row;
        ecol = col; 
    }

    public Seat(boolean Bought, int row, int col, String departure, String destination, Date whenLeaving)
    {
        //eLabel = Label;
        eBought = Bought; 
        erow = row;
        ecol = col; 
        edeparture = departure;
        edestination = destination; 
        ewhenLeaving = whenLeaving; 
    }

    public boolean isTaken() //returns whether the seat is taken
    {
        return eBought;
    }
    public void changeBoolean(boolean whatTo) //changes status of seat
    {
        eBought = whatTo;
    }

    public String generateLabel() //generates a label for flightdisplay
    {
        if(eBought)
            return "XXX";
        else
        {
            String labelLetter = ""; 
            switch(erow)
            {
                case(0):
                labelLetter = "A";
                break;
                case(1):
                labelLetter = "B";
                break;
                case(2):
                labelLetter = "C";
                break;
                case(3):
                labelLetter = "D";
                break;
                case(4):
                labelLetter = "E";
                break;
                case(5):
                labelLetter = "F";
                break;
                default:
                labelLetter = "X";
                break;
            }
            String toReturn = ecol + labelLetter;
            return toReturn;
        }
    }

    public String customerViewer() //for customers to see the status of the seats they have booked
    {
        String toReturn = ""; 
        if(eBought)
        {
            toReturn += "Leaving from " + edeparture + " to " + edestination + " on " + ewhenLeaving;
        }
        else
            toReturn += "Error: seat not bought";

        return toReturn; 
    }
}
