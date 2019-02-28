package cn.ly.mlc.web.entity.request;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import common.util.StringUtils;

/**
 * 
 * @author shidewen
 *
 */
public class BaseExternalRequest extends BaseRequest{
	
	/**
	 * 外部系统的标识，决定了是哪个公众号的请求，也就是一个外部系统只能服务一个公众号
	 */
	private String p1;
	/**
	 * 来源
	 */
	private String p2;
	/**
	 * openId
	 */
	private String p3;
	/**
	 * 时间戳，调用时间戳xxxxx.yyy, xxxxx是当前时间的毫秒数,yyy是随机数 整体上保证唯一
	 */
	private String p4;
	/**
	 * 积分类型(积分/红包)1 积分　　　2　红包
	 */
	private String p5;
	/**
	 * 积分类型(积分/红包)分类
	 */
	private String p6;
	/**
	 * AES加密(证件类型-证件号码.....)
	 */
	private String p7;
	/**
	 * 证件类型
	 */
	private String p8;
	/**
	 * 证件号码
	 */
	private String p9;
	private String p10;
	private String p11;
	private String p12;
	private String p13;
	private String p14;
	private String p15;
	private String p16;
	/**
	 * 加密方式
	 */
	private String p17;
	/**
	 * 活动id
	 */
	private String p18;
	/**
	 * 返回的跳转地址，如果需要参数则附加在后面
	 */
	private String p98;
	/**
	 * 校验码，所有非校验码参数按照字母序排列，然后namevaluenamevalue这样的形式
	 */
	private String p99;
	
	
	private void addToMap(String name, String value, TreeMap<String, String> map){
		if(!StringUtils.isNullOrEmpty(value)){
			map.put(name, value);
		}
	}
	
	public TreeMap<String, String> getTreeMap(){
		TreeMap<String, String> map = new TreeMap<String, String>();
		addToMap("p1", p1, map);
		addToMap("p2", p2, map);
		addToMap("p3", p3, map);
		addToMap("p4", p4, map);
		addToMap("p5", p5, map);
		addToMap("p6", p6, map);
		addToMap("p7", p7, map);
		addToMap("p8", p8, map);
		addToMap("p9", p9, map);
		addToMap("p10", p10, map);
		addToMap("p11", p11, map);
		addToMap("p12", p12, map);
		addToMap("p13", p13, map);
		addToMap("p14", p14, map);
		addToMap("p15", p15, map);
		addToMap("p16", p16, map);
		addToMap("p17", p17, map);
		addToMap("p18", p18, map);
		addToMap("p98", p98, map);
		addToMap("p99", p99, map);
		return map;
	}
	
	public List<String> getParamList(){
		List<String> list = new ArrayList<String>();
		list.add("p1");
		list.add("p2");
		list.add("p3");
		list.add("p4");
		list.add("p5");
		list.add("p6");
		list.add("p7");
		list.add("p8");
		list.add("p9");
		list.add("p10");
		list.add("p11");
		list.add("p12");
		list.add("p13");
		list.add("p14");
		list.add("p15");
		list.add("p16");
		list.add("p17");
		list.add("p18");
		list.add("p98");
		list.add("p99");
		return list;
	}
	
	/**
	 * @return the p1
	 */
	public String getP1() {
		return p1;
	}
	/**
	 * @param p1 the p1 to set
	 */
	public void setP1(String p1) {
		this.p1 = p1;
	}
	/**
	 * @return the p2
	 */
	public String getP2() {
		return p2;
	}
	/**
	 * @param p2 the p2 to set
	 */
	public void setP2(String p2) {
		this.p2 = p2;
	}
	/**
	 * @return the p3
	 */
	public String getP3() {
		return p3;
	}
	/**
	 * @param p3 the p3 to set
	 */
	public void setP3(String p3) {
		this.p3 = p3;
	}
	/**
	 * @return the p4
	 */
	public String getP4() {
		return p4;
	}
	/**
	 * @param p4 the p4 to set
	 */
	public void setP4(String p4) {
		this.p4 = p4;
	}
	/**
	 * @return the p5
	 */
	public String getP5() {
		return p5;
	}
	/**
	 * @param p5 the p5 to set
	 */
	public void setP5(String p5) {
		this.p5 = p5;
	}
	/**
	 * @return the p6
	 */
	public String getP6() {
		return p6;
	}
	/**
	 * @param p6 the p6 to set
	 */
	public void setP6(String p6) {
		this.p6 = p6;
	}
	/**
	 * @return the p7
	 */
	public String getP7() {
		return p7;
	}
	/**
	 * @param p7 the p7 to set
	 */
	public void setP7(String p7) {
		this.p7 = p7;
	}
	/**
	 * @return the p8
	 */
	public String getP8() {
		return p8;
	}
	/**
	 * @param p8 the p8 to set
	 */
	public void setP8(String p8) {
		this.p8 = p8;
	}
	/**
	 * @return the p9
	 */
	public String getP9() {
		return p9;
	}
	/**
	 * @param p9 the p9 to set
	 */
	public void setP9(String p9) {
		this.p9 = p9;
	}
	/**
	 * @return the p10
	 */
	public String getP10() {
		return p10;
	}
	/**
	 * @param p10 the p10 to set
	 */
	public void setP10(String p10) {
		this.p10 = p10;
	}
	/**
	 * @return the p11
	 */
	public String getP11() {
		return p11;
	}
	/**
	 * @param p11 the p11 to set
	 */
	public void setP11(String p11) {
		this.p11 = p11;
	}
	/**
	 * @return the p12
	 */
	public String getP12() {
		return p12;
	}
	/**
	 * @param p12 the p12 to set
	 */
	public void setP12(String p12) {
		this.p12 = p12;
	}
	/**
	 * @return the p98
	 */
	public String getP98() {
		return p98;
	}
	/**
	 * @param p98 the p98 to set
	 */
	public void setP98(String p98) {
		this.p98 = p98;
	}
	/**
	 * @return the p99
	 */
	public String getP99() {
		return p99;
	}
	/**
	 * @param p99 the p99 to set
	 */
	public void setP99(String p99) {
		this.p99 = p99;
	}

	/**
	 * @return the p13
	 */
	public String getP13() {
		return p13;
	}

	/**
	 * @param p13 the p13 to set
	 */
	public void setP13(String p13) {
		this.p13 = p13;
	}

	/**
	 * @return the p14
	 */
	public String getP14() {
		return p14;
	}

	/**
	 * @param p14 the p14 to set
	 */
	public void setP14(String p14) {
		this.p14 = p14;
	}

	/**
	 * @return the p15
	 */
	public String getP15() {
		return p15;
	}

	/**
	 * @param p15 the p15 to set
	 */
	public void setP15(String p15) {
		this.p15 = p15;
	}

	/**
	 * @return the p16
	 */
	public String getP16() {
		return p16;
	}

	/**
	 * @param p16 the p16 to set
	 */
	public void setP16(String p16) {
		this.p16 = p16;
	}

	/**
	 * @return the p17
	 */
	public String getP17() {
		return p17;
	}

	/**
	 * @param p17 the p17 to set
	 */
	public void setP17(String p17) {
		this.p17 = p17;
	}

	/**
	 * @return the p18
	 */
	public String getP18() {
		return p18;
	}

	/**
	 * @param p18 the p18 to set
	 */
	public void setP18(String p18) {
		this.p18 = p18;
	}
	public String serializeToString(){
		return "p1="+checkNull(p1)+"&p2="+checkNull(p2)+"&p3="+checkNull(p3)+"&p4="+checkNull(p4)+"&p5="+checkNull(p5)+"&p6="+checkNull(p6)+"&p7="+checkNull(p7)+"&p8"+checkNull(p8)+"&p9="+checkNull(p9)+"&p10="+checkNull(p10)+"&p11="+checkNull(p11)+"&p12="+checkNull(p12)+"&p13="+checkNull(p13)+"&p14="+checkNull(p14)+"&p15="+checkNull(p15)+"&p16="+checkNull(p16)+"&p17="+checkNull(p17)+"&p18="+checkNull(p18)+"&p98="+checkNull(p98)+"&p99="+checkNull(p99);
	}
	private String checkNull(String str){
		if(StringUtils.isNullOrEmpty(str)){
			return "";
		}
		return str;
	}
	
}
