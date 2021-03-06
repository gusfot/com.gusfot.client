package com.wadiz.client.kds.persistence;

import java.util.List;

import com.wadiz.client.kds.model.TbInvestKsdAccountCheck;

public interface TbInvestKsdAccountCheckMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TbInvestKsdAccountCheck
	 * @mbggenerated  Thu Jan 28 17:28:27 KST 2016
	 */
	int deleteByPrimaryKey(Integer investId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TbInvestKsdAccountCheck
	 * @mbggenerated  Thu Jan 28 17:28:27 KST 2016
	 */
	int insert(TbInvestKsdAccountCheck record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TbInvestKsdAccountCheck
	 * @mbggenerated  Thu Jan 28 17:28:27 KST 2016
	 */
	int insertSelective(TbInvestKsdAccountCheck record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TbInvestKsdAccountCheck
	 * @mbggenerated  Thu Jan 28 17:28:27 KST 2016
	 */
	TbInvestKsdAccountCheck selectByPrimaryKey(Integer investId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TbInvestKsdAccountCheck
	 * @mbggenerated  Thu Jan 28 17:28:27 KST 2016
	 */
	int updateByPrimaryKeySelective(TbInvestKsdAccountCheck record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TbInvestKsdAccountCheck
	 * @mbggenerated  Thu Jan 28 17:28:27 KST 2016
	 */
	int updateByPrimaryKey(TbInvestKsdAccountCheck record);

	List<TbInvestKsdAccountCheck> selectListByStat(String stat);

	int updateByInvestId(TbInvestKsdAccountCheck record);
}