package com.coderscampus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FileReadingService
{
  public List<String> readFile (String filename)
  {
    List<String> lines = null;
    try
    {
      lines = Files.readAllLines(Paths.get(filename));
    } catch (IOException e)
    {
      e.printStackTrace();
    }
    return lines;
  }
}
