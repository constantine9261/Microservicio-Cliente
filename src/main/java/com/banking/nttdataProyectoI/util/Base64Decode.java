package com.banking.nttdataProyectoI.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
@Component
public class Base64Decode implements MultipartFile {

  private final byte[] fileContent;
  private final String fileName;
  private final String extension;
  private final String contentType;

  /**
   * Base64Decode constructor.
   */
  public Base64Decode(String base64, String dataUri, String fileName) {
    //this.fileContent = Base64.decodeBase64(base64.getBytes(StandardCharsets.UTF_8));
    this.fileContent = Base64.getDecoder().decode(base64.getBytes(StandardCharsets.UTF_8));
    this.extension = dataUri.split(Constants.SEMICOLON)[0].split(Constants.SLASH)[1];
    this.contentType = dataUri.split(Constants.SEMICOLON)[0].split(Constants.COLON)[1];
    this.fileName = fileName;
  }

  @Override
  public String getName() {
    return fileName;
  }

  @Override
  public String getOriginalFilename() {
    return fileName + Constants.DOT + extension;
  }

  @Override
  public String getContentType() {
    return contentType;
  }

  @Override
  public boolean isEmpty() {
    return fileContent == null || fileContent.length == 0;
  }

  @Override
  public long getSize() {
    return fileContent.length;
  }

  @Override
  public byte[] getBytes() throws IOException {
    return fileContent;
  }

  @Override
  public InputStream getInputStream() throws IOException {
    return new ByteArrayInputStream(fileContent);
  }

  @Override
  public void transferTo(File file) throws IOException {
    try (FileOutputStream fos = new FileOutputStream(file)) {
      fos.write(fileContent);
    }
  }

}
