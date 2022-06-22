package ec.edu.epn;

import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileWriter;

public class CSV
{
    public static void main(String[] args) throws Exception
    {
        String csv = "data.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(csv));

        //Create record
        String [] record = "4,David,Miller,Australia,30".split(",");
        //Write the record to file
        writer.writeNext(record);

        //close the writer
        writer.close();
    }
}
