package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import guestbook.model.Message;
import jdbc.jdbcUtil;

public class MessageDao {

	// 싱글톤 패턴
	private MessageDao() {
	}

	private static MessageDao dao = new MessageDao();

	public static MessageDao getInstance() {
		return dao;
	}

	// 방명록에 데이터를 저장
	public int insertMessage(Connection conn, Message message) throws SQLException {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		try {
			// 입력을 위한 sql문
			String sql = " INSERT INTO `open`.`guestbook_message` (guest_name,password,message) VALUES (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getGuestName());
			pstmt.setString(2, message.getPassword());
			pstmt.setString(3, message.getMessage());

			resultCnt = pstmt.executeUpdate();

		} finally {
			pstmt.close();
		}

		return resultCnt;
	}

	// 전체 게시물의 개수를 구하는 메소드
	public int selectAllcount(Connection conn) throws SQLException {
		int totalCnt = 0;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "select count(*) from guestbook_message";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				totalCnt = rs.getInt(1); // 첫번째 컬럼
			}
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(stmt);

		}

		return totalCnt;
	}

	public List<Message> selectList(Connection conn, int firstrow, int messageCountPerPage) throws SQLException {

		List<Message> list = new ArrayList<Message>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from open.guestbook_message order by message_id desc limit ?,?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, firstrow);
			pstmt.setInt(2, messageCountPerPage);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(makeMessage(rs));
			}
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}

		return list;
	}

	private Message makeMessage(ResultSet rs) throws SQLException {

		Message message = new Message();
		message.setId(rs.getInt(1));
		message.setGuestName(rs.getString(2));
		message.setPassword(rs.getNString(3));
		message.setMessage(rs.getNString(4));
		message.setWritedate(rs.getTimestamp(5));

		return message;
	}

	public Message selectMessage(Connection conn, int mid) throws SQLException {

		Message message = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from open.guestbook_message where message_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				message = makeMessage(rs);
			}
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
		return message;
	}

	public int deleteMessage(Connection conn, int mid) throws SQLException {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM `open`.`guestbook_message` WHERE message_id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);

			resultCnt = pstmt.executeUpdate();

		} finally {
			jdbcUtil.close(pstmt);
		}
		return resultCnt;
	}
}
