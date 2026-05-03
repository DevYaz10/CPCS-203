// Name: Manaf Aljuhany
// Student ID: 2538489
// Section: IS2
// Assignment Number: 1

import java.io.*;

// The Main class is the starting point of the Library System
class Main {

    public static void main(String[] args) {
        // Initializes the LibrarySystem and processes the input file
        LibrarySystem system = new LibrarySystem();
        system.processFile("input.txt", "LibraryDB.txt");
    }
}

// LibrarySystem class for managing books, members, fines, and records
class LibrarySystem {
    // Arrays used for storing library information
    private Book[] books;             // Array holding Book objects currently in the library
    private Member[] members;         // Array of Member objects who are registered
    private double[][] fineRules;     // 2D array for fine amounts based on type and severity
    private String[] fineCodes;       // Array to map fine types to their respective fineRules rows
    private BorrowRecord[] records;   // Array storing all BorrowRecord objects

    // Counters to keep track of elements in each array
    private int bookCount = 0;        // Current count of books added
    private int memberCount = 0;      // Current count of members added
    private int fineRuleCount = 0;    // Current count of fine rule types
    private int recordCount = 0;      // Current count of borrow records
    private int nextRecordNo = 1;     // Auto-incrementing number for records, starting from 1

    // Reads the input, processes commands, and writes to an output file
    public void processFile(String inputFile, String outputFile) {
        // Verifies the existence of the input file before reading
        File file = new File(inputFile);
        if (!file.exists()) {
            System.out.println("Error: Input file '" + inputFile + "' not found.");
            return;
        }

        // Opens the input file with BufferedReader for reading line by line
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            // Reads first line for book and member array sizes
            String firstLine = br.readLine();
            if (firstLine == null)
                return;

            // Splits first line to get the two size values
            String[] firstParts = firstLine.trim().split("\\s+");
            int booksSize = Integer.parseInt(firstParts[0]);    // Max limit for books array
            int membersSize = Integer.parseInt(firstParts[1]);  // Max limit for members array

            // Reads count of fine types and max records from next lines
            int fineTypes = Integer.parseInt(br.readLine().trim());   // Count of fine rule types
            int recordsSize = Integer.parseInt(br.readLine().trim()); // Max limit for borrow records array

            // Creates arrays using the sizes from the input file
            books = new Book[booksSize];
            members = new Member[membersSize];
            fineRules = new double[fineTypes][];  // Ragged array: rows are created, columns defined per fine type later
            fineCodes = new String[fineTypes];
            records = new BorrowRecord[recordsSize];

            // Reads and handles each command from the input file
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();

                // Ignore lines that are empty
                if (line.isEmpty()) {
                    continue;
                }

                // Splits line into the command and its parameters
                String[] parts = line.split("\\s+");
                String command = parts[0];

                // Runs the correct method for the given command
                switch (command) {
                    case "AddBook":
                        addBook(parts[1], parts[2], parts[3], Integer.parseInt(parts[4]));
                        break;

                    case "AddMember":
                        addMember(parts[1], parts[2], parts[3], Integer.parseInt(parts[4]));
                        break;

                    case "AddFineRule":
                        addFineRule(parts);
                        break;

                    case "IssueBorrow":
                        generateBorrow(parts[1], parts[2], parts[3], Integer.parseInt(parts[4]));
                        break;

                    case "Quit":
                        writeOutput(outputFile);
                        return; // Ends processing when Quit command is encountered
                }
            }

            // Writes output if file ends without Quit command
            writeOutput(outputFile);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Creates a new Book and adds it to the books array
    public void addBook(String isbn, String title, String author, int publishYear) {
        books[bookCount++] = new Book(isbn, title, author, publishYear);
    }

    // Creates a new Member and adds it to the members array
    public void addMember(String memberID, String firstName, String lastName, int birthYear) {
        members[memberCount++] = new Member(memberID, firstName, lastName, birthYear);
    }

    // Adds or modifies a fine rule in the ragged 2D array
    public void addFineRule(String[] parts) {
        String fineCode = parts[1];                  // The name of the fine type
        int levels = Integer.parseInt(parts[2]);     // Count of severity levels for the fine type

        // Checks if the fine code is already in the fineCodes array
        int index = findFineCodeIndex(fineCode);
        if (index == -1) {
            // New fine code: gives it the next available position
            index = fineRuleCount;
            fineCodes[fineRuleCount++] = fineCode;
        }

        // Adds a new row in fineRules with the specified severity levels
        fineRules[index] = new double[levels];
        // Populates each severity level with its respective fine amount
        for (int i = 0; i < levels; i++) {
            fineRules[index][i] = Double.parseDouble(parts[3 + i]);
        }
    }

    // Creates a BorrowRecord by linking book, member, and fine, then saves to array
    public void generateBorrow(String isbn, String memberID, String fineCode, int severity) {
        // Looks up the book and member by their ID and ISBN
        Book book = findBookByISBN(isbn);
        Member member = findMemberByID(memberID);

        // Ensures both book and member were correctly found
        if (book == null || member == null) {
            System.out.println("Error: Book or Member not found.");
            return;
        }

        // Ensures fine code is valid and severity is in range
        int fineIndex = findFineCodeIndex(fineCode);
        if (fineIndex == -1 || severity < 1 || severity > fineRules[fineIndex].length) {
            System.out.println("Error: Invalid fine code or severity.");
            return;
        }

        // Retrieves base fine from ragged array using severity level
        double baseFine = fineRules[fineIndex][severity - 1];

        // Creates BorrowRecord with unique ID and stores it in array
        BorrowRecord record = new BorrowRecord(nextRecordNo++, book, member, fineCode, severity, baseFine);
        records[recordCount++] = record;
    }

    // Writes details of a single borrow record to output file
    public void printBorrow(PrintWriter writer, BorrowRecord record) {
        // Prints header and main info for the record
        writer.println("=============== Borrow Record Information ===============");
        writer.println("Record No= " + record.getRecordNo());
        writer.println("Fine Code= " + record.getFineCode());
        writer.println("Severity= " + record.getSeverity());
        writer.println("Base Fine= " + String.format("%.1f", record.getBaseFine()));
        writer.println();

        // Prints book details from the Book object in the record
        writer.println("Book Information");
        writer.println("ISBN= " + record.getBook().getIsbn());
        writer.println("Title= " + record.getBook().getTitle());
        writer.println("Author= " + record.getBook().getAuthor());
        writer.println("Publish Year= " + record.getBook().getPublishYear());
        writer.println();

        // Prints member details from the Member object in the record
        writer.println("Member Information");
        writer.println("ID= " + record.getMember().getMemberID());
        writer.println("Name= " + record.getMember().getFirstName() + " " + record.getMember().getLastName());
        writer.println("Birth Year= " + record.getMember().getBirthYear());
        writer.println();

        // Prints the total fine including any extra penalties
        writer.println("Total Fine= " + String.format("%.1f", record.calculateFinalFine()));
        writer.println();
    }

    // Writes summary of borrows for each member to output
    public void printBorrowsPerMember(PrintWriter writer) {
        writer.println("-------- Total Borrow(s) Per Member --------");
        writer.println("Member ID     Name           Total Borrows");

        // Iterates through members to count their total borrow records
        for (int i = 0; i < memberCount; i++) {
            Member member = members[i];
            int totalBorrows = 0;

            // Counts borrow records for a member by matching IDs
            for (int j = 0; j < recordCount; j++) {
                if (records[j].getMember().getMemberID().equals(member.getMemberID())) {
                    totalBorrows++;
                }
            }

            // Formats and write member info into columns
            String fullName = member.getFirstName() + " " + member.getLastName();
            writer.printf("%-13s %-14s %d%n", member.getMemberID(), fullName, totalBorrows);
        }
    }

    // Writes borrow records and summary table to the output file
    private void writeOutput(String outputFile) {
        // Opens output file with PrintWriter, overwriting previous content
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile, false))) {
            // Prints each borrow record in creation order
            for (int i = 0; i < recordCount; i++) {
                printBorrow(writer, records[i]);
            }
            writer.println();
            // Prints the summary table after the records
            printBorrowsPerMember(writer);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Searches books array for a book with the matching ISBN
    private Book findBookByISBN(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                return books[i];
            }
        }
        return null;
    }

    // Searches members array for a member with the matching ID
    private Member findMemberByID(String memberID) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getMemberID().equals(memberID)) {
                return members[i];
            }
        }
        return null;
    }

    // Searches fineCodes array for a matching fine code string
    private int findFineCodeIndex(String fineCode) {
        for (int i = 0; i < fineRuleCount; i++) {
            if (fineCodes[i] != null && fineCodes[i].equals(fineCode)) {
                return i;
            }
        }
        return -1;
    }
}

// Book class stores info about a book like ISBN, title, author, and year
class Book {
    private String isbn;         // The book's unique ISBN number
    private String title;        // The book's title
    private String author;       // The book's author
    private int publishYear;     // The year the book was published

    // Default constructor initializing an empty Book object
    public Book() {
    }

    // Constructor with parameters to set all book fields
    public Book(String isbn, String title, String author, int publishYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
    }

    // Returns the ISBN number for the book
    public String getIsbn() {
        return isbn;
    }

    // Sets the ISBN number for the book
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Returns the title of the book
    public String getTitle() {
        return title;
    }

    // Sets the title for the book
    public void setTitle(String title) {
        this.title = title;
    }

    // Returns the author of the book
    public String getAuthor() {
        return author;
    }

    // Sets the author for the book
    public void setAuthor(String author) {
        this.author = author;
    }

    // Returns the publication year of the book
    public int getPublishYear() {
        return publishYear;
    }

    // Sets the publication year for the book
    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    // Formats book information into a string for output
    @Override
    public String toString() {
        return "ISBN= " + isbn + "\n" +
                "Title= " + title + "\n" +
                "Author= " + author + "\n" +
                "Publish Year= " + publishYear;
    }
}

// Member class stores member info like ID, name, and birth year
class Member {
    private String memberID;     // The unique ID for the library member
    private String firstName;    // Member's first name
    private String lastName;     // Member's last name
    private int birthYear;       // Member's year of birth

    // Default constructor initializing an empty Member object
    public Member() {
    }

    // Constructor with parameters to set all member fields
    public Member(String memberID, String firstName, String lastName, int birthYear) {
        this.memberID = memberID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    // Returns the ID of the member
    public String getMemberID() {
        return memberID;
    }

    // Sets the ID for the member
    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    // Returns the member's first name
    public String getFirstName() {
        return firstName;
    }

    // Sets the first name for the member
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Returns the member's last name
    public String getLastName() {
        return lastName;
    }

    // Sets the last name for the member
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Returns the year of birth for the member
    public int getBirthYear() {
        return birthYear;
    }

    // Sets the year of birth for the member
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    // Returns member info formatted as a multi-line string
    @Override
    public String toString() {
        return "ID= " + memberID + "\n" +
                "Name= " + firstName + " " + lastName + "\n" +
                "Birth Year= " + birthYear;
    }
}

// BorrowRecord class links a book and member for a borrow transaction
class BorrowRecord {
    private int recordNo;        // Unique auto-incrementing number for the borrow record
    private Book book;           // The Book object linked to this record
    private Member member;       // The Member object linked to this record
    private String fineCode;     // Code representing the type of fine
    private int severity;        // Level of severity for the fine
    private double baseFine;     // The initial fine amount from the fine rules

    // Default constructor initializing an empty BorrowRecord
    public BorrowRecord() {
    }

    // Constructor with parameters to set all borrow record fields
    public BorrowRecord(int recordNo, Book book, Member member, String fineCode, int severity, double baseFine) {
        this.recordNo = recordNo;
        this.book = book;
        this.member = member;
        this.fineCode = fineCode;
        this.severity = severity;
        this.baseFine = baseFine;
    }

    // Calculates final fine by adding extra charges to the base fine
    public double calculateFinalFine() {
        double totalFine = baseFine;

        // Calculates the member's age using the current year
        int currentYear = 2026;
        int age = currentYear - member.getBirthYear();

        // Extra charge for members younger than 18
        if (age < 18) {
            totalFine += 100;
        }

        // Extra charge for books published before 2000
        if (book.getPublishYear() < 2000) {
            totalFine += 50;
        }

        return totalFine;
    }

    // Returns the borrow record number
    public int getRecordNo() {
        return recordNo;
    }

    // Sets the number for the borrow record
    public void setRecordNo(int recordNo) {
        this.recordNo = recordNo;
    }

    // Returns the Book object for this record
    public Book getBook() {
        return book;
    }

    // Sets the Book object associated with this record
    public void setBook(Book book) {
        this.book = book;
    }

    // Returns the Member object for this record
    public Member getMember() {
        return member;
    }

    // Sets the Member object associated with this record
    public void setMember(Member member) {
        this.member = member;
    }

    // Returns the fine code string
    public String getFineCode() {
        return fineCode;
    }

    // Sets the fine code for this record
    public void setFineCode(String fineCode) {
        this.fineCode = fineCode;
    }

    // Returns the record's severity level
    public int getSeverity() {
        return severity;
    }

    // Sets the severity level for this record
    public void setSeverity(int severity) {
        this.severity = severity;
    }

    // Returns the base fine for the record
    public double getBaseFine() {
        return baseFine;
    }

    // Sets the base fine for this record
    public void setBaseFine(double baseFine) {
        this.baseFine = baseFine;
    }

    // Formats the full borrow record details into a multi-line string
    @Override
    public String toString() {
        return "=============== Borrow Record Information ===============\n" +
                "Record No= " + recordNo + "\n" +
                "Fine Code= " + fineCode + "\n" +
                "Severity= " + severity + "\n" +
                "Base Fine= " + String.format("%.1f", baseFine) + "\n\n" +
                "Book Information\n" +
                book.toString() + "\n\n" +
                "Member Information\n" +
                member.toString() + "\n\n" +
                "Total Fine= " + String.format("%.1f", calculateFinalFine()) + "\n";
    }
}