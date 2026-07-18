import java.util.Scanner;
public class miniFlightReservationSystemArray {
    static Scanner reader = new Scanner(System.in);

    static String username = "user";
    static String password = "user123";
    static boolean isLoggedln = false;
    static int attempts = 3;
    static boolean isCheckedIn = false;       //silinebilir...


    static String[] passengers = {
         "",
         "",
         "",
         "",
         "",
    };
    static String[] flightNumbers = {
        "TK148",
        "TK149",
        "TK150",
        "TK151",
        "TK152",
    };
    static String[] destinations = {
        "Lisbon",
        "Tokyo",
        "Ottowa",
        "Berlin",
        "Ankara",
    };
    static boolean[] checkedIn = {
        false,
        false,
        false,
        false,
        false,
    };
    static int[] ticketPrices = {
        8550,
        9725,
        8000,
        9000,
        9500,
    };
    static String[] flightTimes = {
        "02.30",
        "05.50",
        "08.00",
        "15.40",
        "23.20",
    };
    static int[] distances = {
        40000,
        55000,
        32000,
        45000,
        52500,
    };
    public static void main(String[] args){
        loginSystem();
        if(isLoggedln){
            menuSystem();
        }else{
            System.out.println("Access Denied.");
        }
        reader.close();
    }
    public static void loginSystem(){
        while(attempts > 0){
            System.out.print("Enter username: ");
            String enteredUserName = reader.nextLine();

            System.out.print("Enter password: ");
            String enteredPassword = reader.nextLine();

            if(enteredUserName.equals(username) && enteredPassword.equals(password)){
                System.out.println("Login successful.");
                isLoggedln = true;
                return;
            }else{
                attempts--;
                System.out.println("Wrong login info.");
                System.out.println("Remaining attempts: " + attempts);
            }
        }
    }
    public static void menuSystem(){
        int choice;
        do{
            showMenu();
            choice = reader.nextInt();
            reader.nextLine();
            switch(choice){
                case 1:
                    showFlights();
                    break;
                case 2:
                    searchDestination();
                    break;
                case 3:
                    reserveFlight();
                    break;
                case 4:
                    checkInPassenger();
                    break;
                case 5:
                    cancelReservation();
                    break;
                case 6:
                    showMostExpensiveFlight();
                    break;
                case 7:
                    showCheapestFlight();
                    break;
                case 8:
                    calculateAverageTicketPrice();
                    break;
                case 9:
                    showLongestDistance();
                    break;
                case 10:
                    showShortestPassengerName();
                    break;
                case 11:
                    calculateIncome();
                    break;
                case 12:
                    showOccupancyRate();
                    break;
                case 13:
                    searchCity();
                    break;
                case 14:
                    showTop3ExpensiveTickets();
                    break;
                case 15:
                    showCheckdInPassengers();
                    break;
                case 16:
                    showPendingPassengers();
                    break;
                case 17:
                    countCheckedInPassengers();
                    break;
                case 18:
                    countPendingPassengers();
                    break;
                case 19:
                    showFlightsAboveAveragePrice();
                    break;
                case 20:
                    showDomesticFlights();
                    break;
                case 21:
                    showInternationalFlights();
                    break;
                case 22:
                    showFlightsStartingWithA();
                    break;
                case 23:
                    showFlightsEndingWithN();
                    break;
                case 24:
                    showLongestFlightNumber();
                    break;
                case 25:
                    showFlightSummary();
                    break;
                case 26:
                    exitSystem();
                    break;
                    default:
                        System.out.println("Invalid Choice.");
            }
        }while(choice != 26);
    }
    public static void showMenu(){
        System.out.println("======FLIGHT RESERVATION SYSTEM======");
        System.out.println("1-Show Flights");
        System.out.println("2-Search Destination");
        System.out.println("3-Reserve Flight");
        System.out.println("4-Check In Passenger");
        System.out.println("5-Cancel Reservation");
        System.out.println("6-Show Most Expensive Flight");
        System.out.println("7-Show Cheapest Flight");
        System.out.println("8-Calculate Average Ticket Price");
        System.out.println("9-Show Longest Destination");
        System.out.println("10-Show Shortest Passenger Name");
        System.out.println("11-Calculate Income");
        System.out.println("12-Show Occupancy Rate");
        System.out.println("13-Search City");
        System.out.println("14-Show TOP 3 Expensive Tickets");
        System.out.println("15-Show Checked In Passengers");
        System.out.println("16-Show Pending Passengers");
        System.out.println("17-Count Checked In Passengers");
        System.out.println("18-Count Pending Passengers");
        System.out.println("19-Show Flights Above Average Price");
        System.out.println("20-Show Domestic Flights");
        System.out.println("21-Show International Flights");
        System.out.println("22-Show Flights Starting With A");
        System.out.println("23-Show Flights Ending With A");
        System.out.println("24-Show Longest Flight Number");
        System.out.println("25-Show FLight Summary");
        System.out.println("26-Exit");
    }
    public static void showFlights(){
        System.out.println("\n----FLIGHTS-----");
        for(int i=0;i<passengers.length;i++){
            System.out.println("Passenger: " + passengers[i] + "|Destination: " + destinations[i] + "|Flight: " + flightNumbers[i] + "|Time: " + flightTimes + "|Price: " + ticketPrices[i] + "|Checked In: " + checkedIn[i]);
        }
    }
    public static void searchDestination(){
        System.out.print("Enter destination: ");
        String destination = reader.nextLine();
        for(int i=0;i<destinations.length;i++){
            if(destinations[i].equalsIgnoreCase(destination)){
                System.out.println("Destination Found.");
                System.out.println(destinations[i] + "|Flight: " + flightNumbers[i] +"|Price: " +  ticketPrices[i]);
                return;
            }
        }
        System.out.println("Destination Not Found.");
    }
    public static void reserveFlight(){
        System.out.print("Enter passenger name: ");
        String passenger = reader.nextLine();
        for(int i=0;i<passengers.length;i++){
        if(passengers[i].equals("")){
            passengers[i] += passenger;
            System.out.println("Reservation completed successfully.");
            return;
        }
        }
        System.out.println("No empty seat available.");
    }
    public static void checkInPassenger(){
            System.out.print("Enter passenger name: ");
            String passenger = reader.nextLine();
            for(int i=0;i<passengers.length;i++){
                if(passengers[i].equalsIgnoreCase(passenger)){
                    if(checkedIn[i]){
                        System.out.println("Passenger already checked in.");
                        return;
                    }
                    checkedIn[i] = true;
                    System.out.println("Check-in completed.");
                    return;
                }
    } 
    System.out.println("Passenger not found.");
    }
    public static void cancelReservation(){
        System.out.print("Enter passenger name: ");
        String passenger = reader.nextLine();

        for(int i=0;i<passengers.length;i++){
         if(passengers[i].equalsIgnoreCase(passenger)){
            passengers[i] = "";
            checkedIn[i] = false;
            System.out.println("Reservation cancelled.");
            return;
         }
        }
       System.out.println("Passenger not found.");
    }
    public static void showTop3ExpensiveTickets(){
        System.out.println("\n---TOP 3 EXPENSIVE TICKETS---");
        double first = -1;
        double second = -1;
        double third = -1;

        String firstFlight = "";
        String secondFlight = "";
        String thirdFlight = "";

        for(int i=0;i<ticketPrices.length;i++){
            if(ticketPrices[i] > first){
                third = second;
                thirdFlight = secondFlight;

                second = first;
                secondFlight = firstFlight;

                first = ticketPrices[i];
                firstFlight = destinations[i];
            }else if(ticketPrices[i] > second){
                third = second;
                thirdFlight = secondFlight;

                second = ticketPrices[i];
                secondFlight = destinations[i];
            }else if(ticketPrices[i] > third){
                third = ticketPrices[i];
                thirdFlight = destinations[i];
            }
        }
        System.out.println("1." + firstFlight + "->" + first);
        System.out.println("2." + secondFlight + "->" + second);
        System.out.println("3." + thirdFlight + "->" + third);
    }
    public static void showFlightSummary(){
        for(int i=0;i<passengers.length;i++){
            System.out.println("\n" + passengers[i] + "->" + destinations[i] + "->" + flightTimes[i]);
        }
    }
    public static void showInternationalFlights(){
        System.out.println("\n--- INTERNATIONAL FLIGHTS ---");

    for (int i = 0; i < destinations.length; i++) {
        if (!destinations[i].equalsIgnoreCase("Ankara")) {
            System.out.println(destinations[i] + " -> " + flightNumbers[i]);
        }
    }
    }
    public static void showDomesticFlights(){
        System.out.println("\n--- DOMESTIC FLIGHTS ---");

    for (int i = 0; i < destinations.length; i++) {
        if (destinations[i].equalsIgnoreCase("Ankara")) {
            System.out.println(destinations[i] + " -> " + flightNumbers[i]);
        }
    }
    }
    public static void showMostExpensiveFlight(){
        int highest = ticketPrices[0];
        String destination = destinations[0];

        for(int i=0;i<ticketPrices.length;i++){
            if(ticketPrices[i] > highest){
                highest = ticketPrices[i];
                destination = destinations[i];
            }
        }
        System.out.println("Most Expensive Flight: " + destination + "->" + highest);
    }
    public static void showCheapestFlight(){
        int cheapest = ticketPrices[0];
        String destination = destinations[0];

        for(int i=0;i<ticketPrices.length;i++){
            if(ticketPrices[i] < cheapest){
                cheapest = ticketPrices[i];
                destination = destinations[i];
            }
        }
        System.out.println("Cheapest Flight: " + destination  + "->" +  cheapest);
    }
    public static void calculateAverageTicketPrice(){
        int total = 0;
        for(int i=0;i<ticketPrices.length;i++){
            total += ticketPrices[i];
            double average = (double) total/ticketPrices.length;
            System.out.println("Average Ticket Price: " + average);
        }
    }
    public static void showLongestDistance(){
        int longest = distances[0];

        for(int i=0;i<distances.length;i++){
            if(distances[i] > longest){
                longest = distances[i];
            }
        }
        System.out.println("Longest Distance: " + "->" + distances);
    }
    public static void showShortestPassengerName(){
        String shortest = "";
        for(int i=0;i<passengers.length;i++){
            if(!passengers[i].equals("")){
                shortest = passengers[i];
                break;
            }
        }
        if(shortest.equals("")){
            System.out.println("No passengers.");
        }
        for(int i=0;i<passengers.length;i++){
            if(!passengers[i].equals("") && passengers[i].length() < shortest.length()){
                shortest = passengers[i];
            }
        }
        System.out.println("Shortest Passenger Name: " + shortest);
    }
    public static void calculateIncome(){
        int income = 0;
        for(int i=0;i<passengers.length;i++){
            if(!passengers[i].equals("")){
                income += ticketPrices[i];
            }
        }
        System.out.println("Total Income: " + income);
    }
    public static void showFlightsStartingWithA(){
        System.out.println("\n---DESTINATIONS STARTING WITH A---");
        for(int i=0;i<destinations.length;i++){
            if(destinations[i].toUpperCase().startsWith("A")){
                System.out.println(destinations[i]);
            }
        }
    }
    public static void searchCity(){
        System.out.println("Enter city name: ");
        String city = reader.nextLine();
        for(int i=0;i<destinations.length;i++){
            if(destinations[i].equalsIgnoreCase(city)){
                System.out.println(destinations[i] + "|Flight: " + flightNumbers[i] + "|Time: " + flightTimes[i] + "|Price: " + ticketPrices[i]);
                return;
            }
        }
        System.out.println("City not found.");
    }
    public static void showFlightsAboveAveragePrice(){
    int total = 0;

    for (int i = 0; i < ticketPrices.length; i++) {
        total += ticketPrices[i];
    }

    double average = (double) total / ticketPrices.length;

    System.out.println("\nFlights above average price (" + average + " TL)");

    for (int i = 0; i < ticketPrices.length; i++) {
        if (ticketPrices[i] > average) {
            System.out.println(destinations[i] + " -> " + ticketPrices[i] + " TL");
        }
    }
}
    public static void showCheckdInPassengers(){
        System.out.println("\n---CHECKED IN PASSENGERS---");
        for(int i=0;i<checkedIn.length;i++){
            if(checkedIn[i]){
                System.out.println(passengers[i] + "->" + destinations[i]);
            }
        }
    }
    public static void showPendingPassengers(){
        System.out.println("\n---PENDING PASSENGERS---");
        for(int i=0;i<checkedIn.length;i++){
            if(!checkedIn[i] && !passengers[i].equals("")){
                System.out.println(passengers[i] + "->" + destinations[i]);
            }
        }
    }
    public static void countCheckedInPassengers(){
        int count = 0;
        for(int i=0;i<checkedIn.length;i++){
            if(checkedIn[i]){
                count++;
            }
        }        
        System.out.println("Checked In Passengers: " + count);
    }
    public static void countPendingPassengers(){
        int count = 0;
        for(int i=0;i<checkedIn.length;i++){
            if(!checkedIn[i] && !passengers[i].equals("")){
                count++;
            }
        }
        System.out.println("Pending Passengers: " + count);
    }
    public static void showOccupancyRate(){
        int occupied = 0;
        for(int i=0;i<passengers.length;i++){
            if(!passengers[i].equals("")){
                occupied++;
            }
        }
        double rate = (double) occupied*100/passengers.length;
        System.out.println("Occupancy Rate: " + rate);
    }
    public static void showFlightsEndingWithN(){
        System.out.println("\n---DESTINATIONS ENDING WITH N---");
        for(int i=0;i<destinations.length;i++){
            if(destinations[i].toLowerCase().endsWith("N")){
                System.out.println(destinations[i]);
            }
        }
    }
    public static void showLongestFlightNumber(){
        String longestNumber = flightNumbers[0];
        for(int i=0;i<flightNumbers.length;i++){
            if(flightNumbers[i].length() > longestNumber.length()){
                longestNumber = flightNumbers[i];
            }
        }
        System.out.println("Longet Flight Number: " + longestNumber);
    }
    public static void exitSystem(){
        System.out.println("Thank you for using the system.");
        System.out.println("Goodbye!");
    }
} 