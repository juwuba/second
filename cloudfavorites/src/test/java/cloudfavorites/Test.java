package cloudfavorites;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yc.bean.Tag;
import com.yc.util.Dao;

public class Test {
	public static void main(String[] args) {
		SqlSession session=null;
		try {
			session = Dao.getSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Tag> t;
		try {
		t=session.selectList("com.yc.mapper.TagMapper.tagAll");
		System.out.println(t);
		} finally {
		session.close();
		}
	}

}
