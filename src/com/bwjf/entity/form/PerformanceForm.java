package com.bwjf.entity.form;


/**
 * @作者 王培源
 * @创建时间 2017/11/20
 */
public class PerformanceForm {
	private String dataDate;//数据日期
	private String addTime;//录入时间
	//表一数据：新户+老户服务费+报税盘
	private String XXZS; //新戶小规模主盘数量
	private String XXZJ ;//新戶小规模主盘金额
	private String XXFS ;//新戶小规模分盘数量
	private String XXFJ ;//新戶小规模分盘金额
	private String XYZS ;//新戶一般纳税人主盘数量
	private String XYZJ ;//新戶一般纳税人主盘金额
	private String XYFS ;//新戶一般纳税人分盘数量
	private String XYFJ ;//新戶一般纳税人分盘金额
	
	private String LZS ;//老户主盘数量
	private String LZJ ;//老户主盘金额
	private String LFS ;//老户分盘数量
	private String LFJ;//老户分盘金额
	
	private String BSPS;//报税盘数量
	private String BSPJ;//报税盘金额
	
	private String SKPMFGH;//税控盘免费更换
	private String SKPYCGHS;//税控盘有偿更换数量
	private String SKPYCGHJ;//税控盘有偿更换金额
	
	private String ZXS;//总销售收入
	private String YZZ;//已转账
	
	public PerformanceForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDataDate() {
		return dataDate;
	}

	public void setDataDate(String dataDate) {
		dataDate = dataDate.substring(0, 10);
		this.dataDate = dataDate;
	}
	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		addTime = addTime.substring(0, 19);
		this.addTime = addTime;
	}

	public String getXXZS() {
		return XXZS;
	}

	public void setXXZS(String xXZS) {
		XXZS = xXZS;
	}

	public String getXXZJ() {
		return XXZJ;
	}

	public void setXXZJ(String xXZJ) {
		XXZJ = xXZJ;
	}

	public String getXXFS() {
		return XXFS;
	}

	public void setXXFS(String xXFS) {
		XXFS = xXFS;
	}

	public String getXXFJ() {
		return XXFJ;
	}

	public void setXXFJ(String xXFJ) {
		XXFJ = xXFJ;
	}

	public String getXYZS() {
		return XYZS;
	}

	public void setXYZS(String xYZS) {
		XYZS = xYZS;
	}

	public String getXYZJ() {
		return XYZJ;
	}

	public void setXYZJ(String xYZJ) {
		XYZJ = xYZJ;
	}

	public String getXYFS() {
		return XYFS;
	}

	public void setXYFS(String xYFS) {
		XYFS = xYFS;
	}

	public String getXYFJ() {
		return XYFJ;
	}

	public void setXYFJ(String xYFJ) {
		XYFJ = xYFJ;
	}

	

	public String getLZS() {
		return LZS;
	}

	public void setLZS(String lZS) {
		LZS = lZS;
	}

	public String getLZJ() {
		return LZJ;
	}

	public void setLZJ(String lZJ) {
		LZJ = lZJ;
	}

	public String getLFS() {
		return LFS;
	}

	public void setLFS(String lFS) {
		LFS = lFS;
	}

	public String getLFJ() {
		return LFJ;
	}

	public void setLFJ(String lFJ) {
		LFJ = lFJ;
	}

	public String getBSPS() {
		return BSPS;
	}

	public void setBSPS(String bSPS) {
		BSPS = bSPS;
	}

	public String getBSPJ() {
		return BSPJ;
	}

	public void setBSPJ(String bSPJ) {
		BSPJ = bSPJ;
	}


	public String getSKPMFGH() {
		return SKPMFGH;
	}

	public void setSKPMFGH(String sKPMFGH) {
		SKPMFGH = sKPMFGH;
	}

	public String getSKPYCGHS() {
		return SKPYCGHS;
	}

	public void setSKPYCGHS(String sKPYCGHS) {
		SKPYCGHS = sKPYCGHS;
	}

	public String getSKPYCGHJ() {
		return SKPYCGHJ;
	}

	public void setSKPYCGHJ(String sKPYCGHJ) {
		SKPYCGHJ = sKPYCGHJ;
	}

	
	public String getZXS() {
		return ZXS;
	}

	public void setZXS(String zXS) {
		ZXS = zXS;
	}

	public String getYZZ() {
		return YZZ;
	}

	public void setYZZ(String yZZ) {
		YZZ = yZZ;
	}	
	
}
