/*
 * Below is the copyright agreement for IMCJava.
 * 
 * Copyright (c) 2010-2014, Laboratório de Sistemas e Tecnologia Subaquática
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
 */
package pt.lsts.imc;

/**
 *  IMC Message GPS Navigation Data (280)<br/>
 *  Report of GPS navigation data.<br/>
 */

public class GpsNavData extends IMCMessage {

	public static final int ID_STATIC = 280;

	public GpsNavData() {
		super(ID_STATIC);
	}

	public GpsNavData(IMCMessage msg) {
		super(ID_STATIC);
		try{
			copyFrom(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public GpsNavData(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static GpsNavData create(Object... values) {
		GpsNavData m = new GpsNavData();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static GpsNavData clone(IMCMessage msg) throws Exception {

		GpsNavData m = new GpsNavData();
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

	public GpsNavData(long itow, double lat, double lon, float height_ell, float height_sea, float hacc, float vacc, float vel_n, float vel_e, float vel_d, float speed, float gspeed, float heading, float sacc, float cacc) {
		super(ID_STATIC);
		setItow(itow);
		setLat(lat);
		setLon(lon);
		setHeightEll(height_ell);
		setHeightSea(height_sea);
		setHacc(hacc);
		setVacc(vacc);
		setVelN(vel_n);
		setVelE(vel_e);
		setVelD(vel_d);
		setSpeed(speed);
		setGspeed(gspeed);
		setHeading(heading);
		setSacc(sacc);
		setCacc(cacc);
	}

	/**
	 *  @return GPS Millisecond Time of Week (ms) - uint32_t
	 */
	public long getItow() {
		return getLong("itow");
	}

	/**
	 *  @return Latitude (rad) - fp64_t
	 */
	public double getLat() {
		return getDouble("lat");
	}

	/**
	 *  @return Longitude (rad) - fp64_t
	 */
	public double getLon() {
		return getDouble("lon");
	}

	/**
	 *  @return Height above ellipsoid (m) - fp32_t
	 */
	public double getHeightEll() {
		return getDouble("height_ell");
	}

	/**
	 *  @return Height above sea level (m) - fp32_t
	 */
	public double getHeightSea() {
		return getDouble("height_sea");
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
	 *  @return NED North Velocity (m/s) - fp32_t
	 */
	public double getVelN() {
		return getDouble("vel_n");
	}

	/**
	 *  @return NED East Velocity (m/s) - fp32_t
	 */
	public double getVelE() {
		return getDouble("vel_e");
	}

	/**
	 *  @return NED Down Velocity (m/s) - fp32_t
	 */
	public double getVelD() {
		return getDouble("vel_d");
	}

	/**
	 *  @return Speed (3D) (m/s) - fp32_t
	 */
	public double getSpeed() {
		return getDouble("speed");
	}

	/**
	 *  @return Ground Speed (2D) (m/s) - fp32_t
	 */
	public double getGspeed() {
		return getDouble("gspeed");
	}

	/**
	 *  @return Heading (2D) (rad) - fp32_t
	 */
	public double getHeading() {
		return getDouble("heading");
	}

	/**
	 *  @return Speed Accuracy Estimate (m/s) - fp32_t
	 */
	public double getSacc() {
		return getDouble("sacc");
	}

	/**
	 *  @return Course / Heading Accuracy Estimate (rad) - fp32_t
	 */
	public double getCacc() {
		return getDouble("cacc");
	}

	/**
	 *  @param itow GPS Millisecond Time of Week (ms)
	 */
	public GpsNavData setItow(long itow) {
		values.put("itow", itow);
		return this;
	}

	/**
	 *  @param lat Latitude (rad)
	 */
	public GpsNavData setLat(double lat) {
		values.put("lat", lat);
		return this;
	}

	/**
	 *  @param lon Longitude (rad)
	 */
	public GpsNavData setLon(double lon) {
		values.put("lon", lon);
		return this;
	}

	/**
	 *  @param height_ell Height above ellipsoid (m)
	 */
	public GpsNavData setHeightEll(double height_ell) {
		values.put("height_ell", height_ell);
		return this;
	}

	/**
	 *  @param height_sea Height above sea level (m)
	 */
	public GpsNavData setHeightSea(double height_sea) {
		values.put("height_sea", height_sea);
		return this;
	}

	/**
	 *  @param hacc Horizontal Accuracy Estimate (m)
	 */
	public GpsNavData setHacc(double hacc) {
		values.put("hacc", hacc);
		return this;
	}

	/**
	 *  @param vacc Vertical Accuracy Estimate (m)
	 */
	public GpsNavData setVacc(double vacc) {
		values.put("vacc", vacc);
		return this;
	}

	/**
	 *  @param vel_n NED North Velocity (m/s)
	 */
	public GpsNavData setVelN(double vel_n) {
		values.put("vel_n", vel_n);
		return this;
	}

	/**
	 *  @param vel_e NED East Velocity (m/s)
	 */
	public GpsNavData setVelE(double vel_e) {
		values.put("vel_e", vel_e);
		return this;
	}

	/**
	 *  @param vel_d NED Down Velocity (m/s)
	 */
	public GpsNavData setVelD(double vel_d) {
		values.put("vel_d", vel_d);
		return this;
	}

	/**
	 *  @param speed Speed (3D) (m/s)
	 */
	public GpsNavData setSpeed(double speed) {
		values.put("speed", speed);
		return this;
	}

	/**
	 *  @param gspeed Ground Speed (2D) (m/s)
	 */
	public GpsNavData setGspeed(double gspeed) {
		values.put("gspeed", gspeed);
		return this;
	}

	/**
	 *  @param heading Heading (2D) (rad)
	 */
	public GpsNavData setHeading(double heading) {
		values.put("heading", heading);
		return this;
	}

	/**
	 *  @param sacc Speed Accuracy Estimate (m/s)
	 */
	public GpsNavData setSacc(double sacc) {
		values.put("sacc", sacc);
		return this;
	}

	/**
	 *  @param cacc Course / Heading Accuracy Estimate (rad)
	 */
	public GpsNavData setCacc(double cacc) {
		values.put("cacc", cacc);
		return this;
	}

}
