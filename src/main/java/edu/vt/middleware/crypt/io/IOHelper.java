/*
  $Id: IOHelper.java 2744 2013-06-25 20:20:29Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2744 $
  Updated: $Date: 2013-06-25 22:20:29 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Utility class with methods for common IO operations.
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */
public final class IOHelper
{

  /** Buffer size for stream reads. */
  private static final int BUFFER_SIZE = 1024;


  /** Hidden constructor of utility class. */
  private IOHelper() {}


  /**
   * Reads all data from a stream of unknown length.
   *
   * @param  in  Input stream to read.
   *
   * @return  Entire contents of stream.
   *
   * @throws  IOException  On read errors.
   */
  public static byte[] read(final InputStream in)
    throws IOException
  {
    final ByteArrayOutputStream out;
    try {
      out = new ByteArrayOutputStream();

      final byte[] buffer = new byte[BUFFER_SIZE];
      int count;
      while ((count = in.read(buffer)) > -1) {
        out.write(buffer, 0, count);
      }
    } finally {
      in.close();
    }
    return out.toByteArray();
  }


  /**
   * Reads all data from the given file channel. The channel is closed upon
   * completion.
   *
   * @param  channel  File channel to read.
   *
   * @return  Entire contents of channel.
   *
   * @throws  IOException  On read errors.
   */
  public static byte[] read(final FileChannel channel)
    throws IOException
  {
    final ByteBuffer buffer;
    try {
      buffer = ByteBuffer.allocateDirect((int) channel.size());
      channel.read(buffer);
    } finally {
      channel.close();
    }

    final byte[] result = new byte[buffer.flip().limit()];
    buffer.get(result);
    return result;
  }
}
