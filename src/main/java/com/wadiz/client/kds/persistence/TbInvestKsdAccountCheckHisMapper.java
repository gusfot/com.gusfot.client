package com.wadiz.client.kds.persistence;

import com.wadiz.client.kds.model.TbInvestKsdAccountCheckHis;

public interface TbInvestKsdAccountCheckHisMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TbInvestKsdAccountCheckHis
	 * @mbggenerated  Thu Jan 28 17:28:27 KST 2016
	 */
	int deleteByPrimaryKey(Integer hisNo);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TbInvestKsdAccountCheckHis
	 * @mbggenerated  Thu Jan 28 17:28:27 KST 2016
	 */
	int insert(TbInvestKsdAccountCheckHis record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TbInvestKsdAccountCheckHis
	 * @mbggenerated  Thu Jan 28 17:28:27 KST 2016
	 */
	int insertSelective(TbInvestKsdAccountCheckHis record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TbInvestKsdAccountCheckHis
	 * @mbggenerated  Thu Jan 28 17:28:27 KST 2016
	 */
	TbInvestKsdAccountCheckHis selectByPrimaryKey(Integer hisNo);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TbInvestKsdAccountCheckHis
	 * @mbggenerated  Thu Jan 28 17:28:27 KST 2016
	 */
	int updateByPrimaryKeySelective(TbInvestKsdAccountCheckHis record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TbInvestKsdAccountCheckHis
	 * @mbggenerated  Thu Jan 28 17:28:27 KST 2016
	 */
	int updateByPrimaryKey(TbInvestKsdAccountCheckHis record);

	int updateByInvestId(TbInvestKsdAccountCheckHis recordHis);
}