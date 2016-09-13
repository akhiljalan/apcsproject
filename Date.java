
public class Date
{
    private int emonth, eday, eyear;

    public Date(int month, int day, int year)
    {
        emonth = month;
        eday = day;
        eyear = year;
    }
    

    public int getMonth()
    {
        return emonth;
    }

    public int getDay()
    {
        return eday;
    }

    public int getYear()
    {
        return eyear;
    }

    public Date dateDifference(Date then, Date now)
    {

        int fyear = 0;
        int fmonth = 0; 
        int fday = 0; 

        fyear = now.getYear() - then.getYear(); 
        if (then.getMonth() > now.getMonth())
        {
            fyear += 1;
            fmonth = (12 - (now.getMonth() - then.getMonth())); //returns a pos value, then 12 - that
        }
        else 
        {
            if (then.getMonth() > now.getMonth()) fmonth = (then.getMonth() - now.getMonth());
        }
        fday = now.getDay() - then.getDay(); 
        
        Date f = new Date (fyear, fmonth, fday); 

        return f; 
    }

    public double dateForPriceDifference(Date then, Date now)
    {
        double f = 0; 
        Date g = dateDifference(then, now);
        if (g.getMonth() >= 6)
            f = 0.75;//75% of ticket price if 6 months before
        else if (g.getMonth() >= 2)
            f = 0.85; //85% of ticket price if 2 months before
        else if (g.getMonth() > 0)
            f = 1; //standard price if within 30 days
        else if (g.getDay() < 15)
            f = 1.2;//120% of price if within two weeks
        else
            f = 1.5; 
           
        
        return f; 
    }

    public String toString()
    {
        String s = "";//return statement
        switch(emonth)
        {
            case(1): s+= "January"; break;
            case(2): s+= "February"; break;
            case(3): s+= "March"; break;
            case(4): s+= "April"; break;
            case(5): s+= "May"; break;
            case(6): s+= "June"; break;
            case(7): s+= "July"; break;
            case(8): s+= "August"; break;
            case(9): s+= "September"; break;
            case(10): s+= "October"; break;
            case(11): s+= "November"; break;
            case(12): s+= "December"; break;
            default: s+= "Error"; break;
        }
        s += " " + eday + ", " + eyear;
        return s; 
    }
}

