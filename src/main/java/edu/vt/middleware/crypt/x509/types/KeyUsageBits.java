/*
  $Id: KeyUsageBits.java 2745 2013-06-25 21:16:10Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2745 $
  Updated: $Date: 2013-06-25 23:16:10 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.x509.types;

/**
 * Representation of the bit meanings in the <code>KeyUsage</code> BIT STRING
 * type defined in section 4.2.1.3 of RFC 2459.
 *
 * @author  Middleware Services
 * @version  $Revision: 2745 $
 */
public enum KeyUsageBits {

  /** digitalSignature bit. */
  DigitalSignature(7),

  /** nonRepudiation bit. */
  NonRepudiation(6),

  /** keyEncipherment bit. */
  KeyEncipherment(5),

  /** dataEncipherment bit. */
  DataEncipherment(4),

  /** keyAgreement bit. */
  KeyAgreement(3),

  /** keyCertSign bit. */
  KeyCertSign(2),

  /** cRLSign bit. */
  CRLSign(1),

  /** encipherOnly bit. */
  EncipherOnly(0),

  /** decipherOnly bit. */
  DecipherOnly(15);


  /** Bit mask value. */
  private final int mask;


  /**
   * Creates a bit flag with the given bit mask offset.
   *
   * @param  offset  Bit mask offset.
   */
  KeyUsageBits(final int offset)
  {
    mask = 1 << offset;
  }


  /** @return  Bit mask value. */
  public int getMask()
  {
    return mask;
  }

}
