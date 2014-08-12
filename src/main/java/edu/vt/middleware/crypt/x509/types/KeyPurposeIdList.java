/*
  $Id: KeyPurposeIdList.java 2744 2013-06-25 20:20:29Z dfisher $

  Copyright (C) 2003-2013 Virginia Tech.
  All rights reserved.

  SEE LICENSE FOR MORE INFORMATION

  Author:  Middleware Services
  Email:   middleware@vt.edu
  Version: $Revision: 2744 $
  Updated: $Date: 2013-06-25 22:20:29 +0200 (Tue, 25 Jun 2013) $
*/
package edu.vt.middleware.crypt.x509.types;

import java.util.List;

/**
 * Represents the sequence of <code>KeyPurposeId</code> types that are contained
 * in the <code>ExtendedKeyUsage</code> extension field described in section
 * 4.2.1.13 of RFC 2459.
 *
 * @author  Middleware Services
 * @version  $Revision: 2744 $
 */
public class KeyPurposeIdList extends AbstractList<KeyPurposeId>
{

  /**
   * Constructs a new instance from the given list of key purpose identifiers.
   *
   * @param  listOfKeyPurposeIds  List of key purpose identifiers.
   */
  public KeyPurposeIdList(final List<KeyPurposeId> listOfKeyPurposeIds)
  {
    if (listOfKeyPurposeIds == null) {
      throw new IllegalArgumentException(
        "List of key purpose IDs cannot be null.");
    }
    items = listOfKeyPurposeIds.toArray(
      new KeyPurposeId[listOfKeyPurposeIds.size()]);
  }


  /**
   * Constructs a new instance from the given array of key purpose identifiers.
   *
   * @param  arrayOfKeyPurposeIds  Array of key purpose identifiers.
   */
  public KeyPurposeIdList(final KeyPurposeId[] arrayOfKeyPurposeIds)
  {
    if (arrayOfKeyPurposeIds == null) {
      throw new IllegalArgumentException(
        "Array of key purpose IDs  cannot be null.");
    }
    items = arrayOfKeyPurposeIds;
  }
}
