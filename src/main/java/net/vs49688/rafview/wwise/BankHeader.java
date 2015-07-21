/*
 * RAFTools - Copyright (C) 2015 Zane van Iperen.
 *    Contact: zane.vaniperen@uqconnect.edu.au
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2, and only
 * version 2 as published by the Free Software Foundation. 
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * Any and all GPL restrictions may be circumvented with permission from the
 * the original author.
 */
package net.vs49688.rafview.wwise;

import java.nio.*;

public class BankHeader extends Section {

	private final long m_Version;
	private final long m_ID;
	
	public BankHeader(int section, long length, ByteBuffer data) throws WwiseFormatException {
		super(section, length);

		m_Version = (long)data.getInt() & 0xFFFFFFFFL;
		m_ID = (long)data.getInt() & 0xFFFFFFFFL;
		
		if(data.getInt() != 0 || data.getInt() != 0) {
			throw new WwiseFormatException("BKHD: Reserved fields not zero.");
		}
	}
	
	public long getVersion() {
		return m_Version;
	}
	
	public long getID() {
		return m_ID;
	}
}
