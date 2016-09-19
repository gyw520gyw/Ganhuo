package com.gyw.ganhuo.base;

public interface IBaseView<T> {

	/**
	 * 处理服务器返回的数据
	 * @param 服务器返回的数据
	 */
	void handleData(T t);


}
