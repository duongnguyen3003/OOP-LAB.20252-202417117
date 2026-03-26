import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        
        int monthNum = 0;
        int year = -1;

        while(monthNum == 0 || year < 0)
        {
            System.out.print("Enter a month: ");
            String monthInput = in.next();

            System.out.print("Enter a full year (e.g., 99 is the year 99, not 1999): ");
            year = in.nextInt();

            switch(monthInput) 
            {
                case "January": case "Jan.": case "Jan": case "1": monthNum = 1; break;
                case "February": case "Feb.": case "Feb": case "2": monthNum = 2; break;
                case "March": case "Mar.": case "Mar": case "3": monthNum = 3; break;
                case "April": case "Apr.": case "Apr": case "4": monthNum = 4; break;
                case "May": case "5": monthNum = 5; break;
                case "June": case "Jun": case "6": monthNum = 6; break;
                case "July": case "Jul": case "7": monthNum = 7; break;
                case "August": case "Aug.": case "Aug": case "8": monthNum = 8; break;
                case "September": case "Sept.": case "Sep": case "9": monthNum = 9; break;
                case "October": case "Oct.": case "Oct": case "10": monthNum = 10; break;
                case "November": case "Nov.": case "Nov": case "11": monthNum = 11; break;
                case "December": case "Dec.": case "Dec": case "12": monthNum = 12; break;
                default: monthNum = 0; // invalid
            }

            if(monthNum == 0 || year < 0) System.out.println("Invalid input. Please try again.\n");
        }

        int days;
        
        if(monthNum == 4 || monthNum == 6 || monthNum == 9 || monthNum == 11) days = 30;
            
        else if(monthNum == 2)
        {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) days = 29;
            else days = 28;
        } 
        else days = 31;

        System.out.println("There are " + days + " days in this month.");        
        in.close();
    }
}