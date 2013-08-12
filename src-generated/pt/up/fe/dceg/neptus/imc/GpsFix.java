/*
 * Below is the copyright agreement for IMCJava.
 * 
 * Copyright (c) 2010-2013, Laboratório de Sistemas e Tecnologia Subaquática
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     - Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     - Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     - Neither the names of IMC, LSTS, IMCJava nor the names of its 
 *       contributors may be used to endorse or promote products derived from 
 *       this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL LABORATORIO DE SISTEMAS E TECNOLOGIA SUBAQUATICA
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE 
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) 
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT 
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *  
 *                                                                             $:
 */

// Source generated by IMCJava from IMC version 5.2.0
package pt.up.fe.dceg.neptus.imc;

/**
 *  IMC Message GPS Fix (253)<br/>
 *  Report of a GPS fix.<br/>
 */

public class GpsFix extends IMCMessage {

	public static final int ID_STATIC = 253;

	public static final int GFV_VALID_DATE = 0x0001;
	public static final int GFV_VALID_TIME = 0x0002;
	public static final int GFV_VALID_POS = 0x0004;
	public static final int GFV_VALID_COG = 0x0008;
	public static final int GFV_VALID_SOG = 0x0010;
	public static final int GFV_VALID_HACC = 0x0020;
	public static final int GFV_VALID_VACC = 0x0040;
	public static final int GFV_VALID_HDOP = 0x0080;
	public static final int GFV_VALID_VDOP = 0x0100;

	public enum TYPE {
		STANDALONE(0),
		DIFFERENTIAL(1),
		DEAD_RECKONING(2),
		MANUAL_INPUT(3),
		SIMULATION(4);

		protected long value;

		public long value() {
			return value;
		}

		TYPE(long value) {
			this.value = value;
		}
	}

	public GpsFix() {
		super(ID_STATIC);
	}

	public GpsFix(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static GpsFix create(Object... values) {
		GpsFix m = new GpsFix();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static GpsFix clone(IMCMessage msg) throws Exception {

		GpsFix m = new GpsFix();
		if (msg == null)
			return m;
		if(msg.definitions != m.definitions){
			msg = msg.cloneMessage();
			IMCUtil.updateMessage(msg, m.definitions);
		}
		else if (msg.getMgid()!=m.getMgid())
			throw new Exception("Argument "+msg.getAbbrev()+" is incompatible with message "+m.getAbbrev());

		m.getHeader().values.putAll(msg.getHeader().values);
		m.values.putAll(msg.values);
		return m;
	}

	public GpsFix(int validity, TYPE type, int utc_year, short utc_month, short utc_day, float utc_time, double lat, double lon, double height, short satellites, float cog, float sog, float hdop, float vdop, float hacc, float vacc) {
		super(ID_STATIC);
		setValidity(validity);
		setType(type);
		setUtcYear(utc_year);
		setUtcMonth(utc_month);
		setUtcDay(utc_day);
		setUtcTime(utc_time);
		setLat(lat);
		setLon(lon);
		setHeight(height);
		setSatellites(satellites);
		setCog(cog);
		setSog(sog);
		setHdop(hdop);
		setVdop(vdop);
		setHacc(hacc);
		setVacc(vacc);
	}

	/**
	 *  Validity of fields.<br/>
	 *  @return Validity (bitfield) - uint16_t
	 */
	public int getValidity() {
		return getInteger("validity");
	}

	/**
	 *  Type of fix.<br/>
	 *  @return Type (enumerated) - uint8_t
	 */
	public TYPE getType() {
		try {
			TYPE o = TYPE.valueOf(getMessageType().getFieldPossibleValues("type").get(getLong("type")));
			return o;
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 *  @return UTC Year - uint16_t
	 */
	public int getUtcYear() {
		return getInteger("utc_year");
	}

	/**
	 *  @return UTC Month - uint8_t
	 */
	public short getUtcMonth() {
		return (short) getInteger("utc_month");
	}

	/**
	 *  @return UTC Day - uint8_t
	 */
	public short getUtcDay() {
		return (short) getInteger("utc_day");
	}

	/**
	 *  @return UTC Time of Fix (s) - fp32_t
	 */
	public double getUtcTime() {
		return getDouble("utc_time");
	}

	/**
	 *  @return Latitude WGS-84 (rad) - fp64_t
	 */
	public double getLat() {
		return getDouble("lat");
	}

	/**
	 *  @return Longitude WGS-84 (rad) - fp64_t
	 */
	public double getLon() {
		return getDouble("lon");
	}

	/**
	 *  @return Height above WGS-84 ellipsoid (m) - fp64_t
	 */
	public double getHeight() {
		return getDouble("height");
	}

	/**
	 *  @return Number of Satellites - uint8_t
	 */
	public short getSatellites() {
		return (short) getInteger("satellites");
	}

	/**
	 *  @return Course Over Ground (rad) - fp32_t
	 */
	public double getCog() {
		return getDouble("cog");
	}

	/**
	 *  @return Speed Over Ground (m/s) - fp32_t
	 */
	public double getSog() {
		return getDouble("sog");
	}

	/**
	 *  @return Horizontal Dilution of Precision - fp32_t
	 */
	public double getHdop() {
		return getDouble("hdop");
	}

	/**
	 *  @return Vertical Dilution of Precision - fp32_t
	 */
	public double getVdop() {
		return getDouble("vdop");
	}

	/**
	 *  @return Horizontal Accuracy Estimate (m) - fp32_t
	 */
	public double getHacc() {
		return getDouble("hacc");
	}

	/**
	 *  @return Vertical Accuracy Estimate (m) - fp32_t
	 */
	public double getVacc() {
		return getDouble("vacc");
	}

	/**
	 *  @param validity Validity (bitfield)
	 */
	public void setValidity(int validity) {
		values.put("validity", validity);
	}

	/**
	 *  @param type Type (enumerated)
	 */
	public void setType(TYPE type) {
		values.put("type", type.value());
	}

	/**
	 *  @param type Type (as a String)
	 */
	public void setType(String type) {
		setValue("type", type);
	}

	/**
	 *  @param type Type (integer value)
	 */
	public void setType(short type) {
		setValue("type", type);
	}

	/**
	 *  @param utc_year UTC Year
	 */
	public void setUtcYear(int utc_year) {
		values.put("utc_year", utc_year);
	}

	/**
	 *  @param utc_month UTC Month
	 */
	public void setUtcMonth(short utc_month) {
		values.put("utc_month", utc_month);
	}

	/**
	 *  @param utc_day UTC Day
	 */
	public void setUtcDay(short utc_day) {
		values.put("utc_day", utc_day);
	}

	/**
	 *  @param utc_time UTC Time of Fix (s)
	 */
	public void setUtcTime(double utc_time) {
		values.put("utc_time", utc_time);
	}

	/**
	 *  @param lat Latitude WGS-84 (rad)
	 */
	public void setLat(double lat) {
		values.put("lat", lat);
	}

	/**
	 *  @param lon Longitude WGS-84 (rad)
	 */
	public void setLon(double lon) {
		values.put("lon", lon);
	}

	/**
	 *  @param height Height above WGS-84 ellipsoid (m)
	 */
	public void setHeight(double height) {
		values.put("height", height);
	}

	/**
	 *  @param satellites Number of Satellites
	 */
	public void setSatellites(short satellites) {
		values.put("satellites", satellites);
	}

	/**
	 *  @param cog Course Over Ground (rad)
	 */
	public void setCog(double cog) {
		values.put("cog", cog);
	}

	/**
	 *  @param sog Speed Over Ground (m/s)
	 */
	public void setSog(double sog) {
		values.put("sog", sog);
	}

	/**
	 *  @param hdop Horizontal Dilution of Precision
	 */
	public void setHdop(double hdop) {
		values.put("hdop", hdop);
	}

	/**
	 *  @param vdop Vertical Dilution of Precision
	 */
	public void setVdop(double vdop) {
		values.put("vdop", vdop);
	}

	/**
	 *  @param hacc Horizontal Accuracy Estimate (m)
	 */
	public void setHacc(double hacc) {
		values.put("hacc", hacc);
	}

	/**
	 *  @param vacc Vertical Accuracy Estimate (m)
	 */
	public void setVacc(double vacc) {
		values.put("vacc", vacc);
	}

}
