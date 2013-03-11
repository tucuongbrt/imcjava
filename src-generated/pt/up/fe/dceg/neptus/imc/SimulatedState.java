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
 * $Id:: ClassGenerator.java 393 2013-03-03 10:40:48Z zepinto@gmail.com        $:
 */

// Source generated by IMCJava from IMC version 5.1.0
package pt.up.fe.dceg.neptus.imc;

/**
 *  IMC Message Simulated State (50)<br/>
 *  This message presents the simulated state of the vehicle. The simulated<br/>
 *  state attempts to provide a realistic state interpretation of operating<br/>
 *  various kinds of vehicles.<br/>
 */

public class SimulatedState extends IMCMessage {

	public static final int ID_STATIC = 50;

	public SimulatedState() {
		super(ID_STATIC);
	}

	public SimulatedState(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static SimulatedState create(Object... values) {
		SimulatedState m = new SimulatedState();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static SimulatedState clone(IMCMessage msg) throws Exception {

		SimulatedState m = new SimulatedState();
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

	public SimulatedState(double lat, double lon, float height, float x, float y, float z, float phi, float theta, float psi, float u, float v, float w, float p, float q, float r, float svx, float svy, float svz) {
		super(ID_STATIC);
		setLat(lat);
		setLon(lon);
		setHeight(height);
		setX(x);
		setY(y);
		setZ(z);
		setPhi(phi);
		setTheta(theta);
		setPsi(psi);
		setU(u);
		setV(v);
		setW(w);
		setP(p);
		setQ(q);
		setR(r);
		setSvx(svx);
		setSvy(svy);
		setSvz(svz);
	}

	/**
	 *  @return Latitude (WGS-84) (rad) - fp64_t
	 */
	public double getLat() {
		return getDouble("lat");
	}

	/**
	 *  @return Longitude (WGS-84) (rad) - fp64_t
	 */
	public double getLon() {
		return getDouble("lon");
	}

	/**
	 *  @return Height (WGS-84) (m) - fp32_t
	 */
	public double getHeight() {
		return getDouble("height");
	}

	/**
	 *  @return Offset north (m) (m) - fp32_t
	 */
	public double getX() {
		return getDouble("x");
	}

	/**
	 *  @return Offset east (m) (m) - fp32_t
	 */
	public double getY() {
		return getDouble("y");
	}

	/**
	 *  @return Offset down (m) (m) - fp32_t
	 */
	public double getZ() {
		return getDouble("z");
	}

	/**
	 *  @return Rotation over x axis (rad) - fp32_t
	 */
	public double getPhi() {
		return getDouble("phi");
	}

	/**
	 *  @return Rotation over y axis (rad) - fp32_t
	 */
	public double getTheta() {
		return getDouble("theta");
	}

	/**
	 *  @return Rotation over z axis (rad) - fp32_t
	 */
	public double getPsi() {
		return getDouble("psi");
	}

	/**
	 *  @return Body-Fixed xx Linear Velocity (m/s) - fp32_t
	 */
	public double getU() {
		return getDouble("u");
	}

	/**
	 *  @return Body-Fixed yy Linear Velocity (m/s) - fp32_t
	 */
	public double getV() {
		return getDouble("v");
	}

	/**
	 *  @return Body-Fixed zz Linear Velocity (m/s) - fp32_t
	 */
	public double getW() {
		return getDouble("w");
	}

	/**
	 *  @return Angular Velocity in x (rad/s) - fp32_t
	 */
	public double getP() {
		return getDouble("p");
	}

	/**
	 *  @return Angular Velocity in y (rad/s) - fp32_t
	 */
	public double getQ() {
		return getDouble("q");
	}

	/**
	 *  @return Angular Velocity in z (rad/s) - fp32_t
	 */
	public double getR() {
		return getDouble("r");
	}

	/**
	 *  @return Stream Velocity X (North) (m/s) - fp32_t
	 */
	public double getSvx() {
		return getDouble("svx");
	}

	/**
	 *  @return Stream Velocity Y (East) (m/s) - fp32_t
	 */
	public double getSvy() {
		return getDouble("svy");
	}

	/**
	 *  @return Stream Velocity Z (Down) (m/s) - fp32_t
	 */
	public double getSvz() {
		return getDouble("svz");
	}

	/**
	 *  @param lat Latitude (WGS-84) (rad)
	 */
	public void setLat(double lat) {
		values.put("lat", lat);
	}

	/**
	 *  @param lon Longitude (WGS-84) (rad)
	 */
	public void setLon(double lon) {
		values.put("lon", lon);
	}

	/**
	 *  @param height Height (WGS-84) (m)
	 */
	public void setHeight(double height) {
		values.put("height", height);
	}

	/**
	 *  @param x Offset north (m) (m)
	 */
	public void setX(double x) {
		values.put("x", x);
	}

	/**
	 *  @param y Offset east (m) (m)
	 */
	public void setY(double y) {
		values.put("y", y);
	}

	/**
	 *  @param z Offset down (m) (m)
	 */
	public void setZ(double z) {
		values.put("z", z);
	}

	/**
	 *  @param phi Rotation over x axis (rad)
	 */
	public void setPhi(double phi) {
		values.put("phi", phi);
	}

	/**
	 *  @param theta Rotation over y axis (rad)
	 */
	public void setTheta(double theta) {
		values.put("theta", theta);
	}

	/**
	 *  @param psi Rotation over z axis (rad)
	 */
	public void setPsi(double psi) {
		values.put("psi", psi);
	}

	/**
	 *  @param u Body-Fixed xx Linear Velocity (m/s)
	 */
	public void setU(double u) {
		values.put("u", u);
	}

	/**
	 *  @param v Body-Fixed yy Linear Velocity (m/s)
	 */
	public void setV(double v) {
		values.put("v", v);
	}

	/**
	 *  @param w Body-Fixed zz Linear Velocity (m/s)
	 */
	public void setW(double w) {
		values.put("w", w);
	}

	/**
	 *  @param p Angular Velocity in x (rad/s)
	 */
	public void setP(double p) {
		values.put("p", p);
	}

	/**
	 *  @param q Angular Velocity in y (rad/s)
	 */
	public void setQ(double q) {
		values.put("q", q);
	}

	/**
	 *  @param r Angular Velocity in z (rad/s)
	 */
	public void setR(double r) {
		values.put("r", r);
	}

	/**
	 *  @param svx Stream Velocity X (North) (m/s)
	 */
	public void setSvx(double svx) {
		values.put("svx", svx);
	}

	/**
	 *  @param svy Stream Velocity Y (East) (m/s)
	 */
	public void setSvy(double svy) {
		values.put("svy", svy);
	}

	/**
	 *  @param svz Stream Velocity Z (Down) (m/s)
	 */
	public void setSvz(double svz) {
		values.put("svz", svz);
	}

}
