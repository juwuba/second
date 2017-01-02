package com.yc.bizimple;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yc.bean.Tag;
import com.yc.biz.TagBiz;
import com.yc.util.Dao;

public class TagBizImple implements TagBiz {

	public List<Tag> findAllTags() {
		SqlSession session=null;
		try {
			session = Dao.getSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Tag> t;
		try {
		t=session.selectList("com.yc.mapper.TagMapper.tagAll");
		} finally {
		session.close();
		}
		return t;
	}

}
