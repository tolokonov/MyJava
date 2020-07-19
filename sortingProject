package sorting;

import java.io.IOException;
import java.util.*;
import  java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sortingType = "natural", dataType = "word", nameOfInputFile = "", nameOfOutputFile = "";
        List entries = null;

        for (int i = 0; i < args.length ; i++) {
            if  (args[i].equals("-sortingType")){
                if (i+1 != args.length) {
                    sortingType = args[i + 1];
                }
            }
            if (args[i].equals("-dataType")){
                if (i+1 != args.length) {
                    dataType = args[i + 1];
                }
            }
            if (args[i].equals("-inputFile")){
                if (i+1 != args.length) {
                    nameOfInputFile = args[i + 1];
                }
            }
            if (args[i].equals("-outputFile")){
                if (i+1 != args.length) {
                    nameOfOutputFile = args[i + 1];
                }
            }
        }

        if (nameOfInputFile == "") {
            if (dataType.equals("word") || dataType.equals("line")) {
                entries = new ArrayList<String>();
                while (scanner.hasNextLine() && dataType.equals("line")) {
                    entries.add(scanner.nextLine());
                }
                while (scanner.hasNext() && dataType.equals("word")) {
                    entries.add(scanner.next());
                }
            } else {
                entries = new ArrayList<Long>();
                while (scanner.hasNextLong()) {
                    entries.add(scanner.nextLong());
                }
            }
        }else{
            try{
                Scanner in = new Scanner(new File(nameOfInputFile));
                if (dataType.equals("word") || dataType.equals("line")) {
                    entries = new ArrayList<String>();
                    while (in.hasNextLine() && dataType.equals("line")) {
                        entries.add(in.nextLine());
                    }
                    while (in.hasNext() && dataType.equals("word")) {
                        entries.add(in.next());
                    }
                } else {
                    entries = new ArrayList<Long>();
                    while (in.hasNextLong()) {
                        entries.add(in.nextLong());
                    }
                }
                in.close();
            }catch(FileNotFoundException e){
                System.out.println(e);
            }
        }

        switch (sortingType){
            case "natural":
                sortNatural(dataType, entries, nameOfOutputFile);
                break;
            case "byCount":
                sortByCount(dataType, entries, nameOfOutputFile);
                break;
        }
    }

    private static void sortByCount(String dataType, List entries, String nameOfOutputFile) {
        if (nameOfOutputFile == "") {
            if (dataType.equals("long")) {
                System.out.println("Total numbers: " + entries.size());
            } else if (dataType.equals("line")) {
                System.out.println("Total lines: " + entries.size());
            } else {
                System.out.println("Total lines: " + entries.size());
            }
            Map<Object, Integer> countMap = new TreeMap<>();
            for (Object o : entries) {
                if (countMap.containsKey(o)) {
                    countMap.put(o, countMap.get(o) + 1);
                } else {
                    countMap.put(o, 1);
                }
            }
            List<Integer> countList = new ArrayList<>(new HashSet<>(countMap.values()));
            Collections.sort(countList);
            for (Integer i : countList) {
                for (Object key : countMap.keySet()) {
                    if (countMap.get(key).equals(i)) {
                        System.out.println(key + ":" + i + " time(s), " + i / entries.size());
                    }
                }
            }
        }
        else{
            File file = new File(nameOfOutputFile);
            try {
                FileWriter writer = new FileWriter(file);
                if (dataType.equals("long")) {
                    writer.write("Total numbers: ");
                    writer.write(entries.size());
                    writer.write("\n");
                } else if (dataType.equals("line")) {
                    writer.write("Total lines: ");
                    writer.write(entries.size());
                    writer.write("\n");
                } else {
                    writer.write("Total lines: ");
                    writer.write(entries.size());
                    writer.write("\n");
                }
                Map<Object, Integer> countMap = new TreeMap<>();
                for (Object o : entries) {
                    if (countMap.containsKey(o)) {
                        countMap.put(o, countMap.get(o) + 1);
                    } else {
                        countMap.put(o, 1);
                    }
                }
                List<Integer> countList = new ArrayList<>(new HashSet<>(countMap.values()));
                Collections.sort(countList);
                for (Integer i : countList) {
                    for (Object key : countMap.keySet()) {
                        if (countMap.get(key).equals(i)) {
                            writer.write(key.toString());
                            writer.write(":");
                            writer.write(i);
                            writer.write(" time(s), ");
                            writer.write(i / entries.size());
                            writer.write("\n");
                        }
                    }
                }
                writer.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void sortNatural(String dataType, List entries, String nameOfOutputFile) {
        if (nameOfOutputFile == "") {
            Collections.sort(entries);
            if (dataType.equals("long")) {
                System.out.println("Total numbers: " + entries.size());
            } else if (dataType.equals("line")) {
                System.out.println("Total lines: " + entries.size());
            } else {
                System.out.println("Total lines: " + entries.size());
            }
            if (dataType.equals("line")) {
                System.out.println("Sorted data:");
                for (Object line : entries) {
                    System.out.println(line);
                }
            } else {
                System.out.print("Sorted data: ");
                for (Object ob : entries) {
                    System.out.print(ob + " ");
                }
            }
        } else  {
            File file = new File(nameOfOutputFile);
            try {
                FileWriter writer = new FileWriter(file);
                Collections.sort(entries);
                if (dataType.equals("long")) {
                    writer.write("Total numbers: ");
                    writer.write(entries.size());
                    writer.write("\n");
                } else if (dataType.equals("line")) {
                    writer.write("Total lines: ");
                    writer.write(entries.size());
                    writer.write("\n");
                } else {
                    writer.write("Total lines: ");
                    writer.write(entries.size());
                    writer.write("\n");
                }
                if (dataType.equals("line")) {
                    writer.write("Sorted data:\n");
                    for (Object line : entries) {
                        writer.write(line.toString());
                        writer.write("\n");
                    }
                    writer.close();
                } else {
                    writer.write("Sorted data:\n");
                    for (Object ob : entries) {
                        writer.write(ob.toString());
                        writer.write(" ");
                    }
                    writer.close();
                }
            }catch(IOException h){
                System.out.println(h.getMessage());
            }
        }
    }
