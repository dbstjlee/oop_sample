package member.repository;

import java.util.HashMap;
import java.util.Map;

import member.Grade;
import member.Member;

public class MemoryMemberRepositoryImpl implements MemberRepository {

	// 싱글톤
	private static MemoryMemberRepositoryImpl instance;
	private Map<Long, Member> memberStore = new HashMap<>(); // 자료구조 메모리 공간만 생성
	
	// 기본 생성자(객체가 인스턴스화 시 생성자 먼저 호출)
	private MemoryMemberRepositoryImpl() {
		initData();
	}
	
	// 싱글톤 외부 접근 메서드(외부에서 인스턴스 주소를 반환 받을 수 있도록 함)
	public static MemoryMemberRepositoryImpl getInstance() {
		if(instance == null) {
			instance = new MemoryMemberRepositoryImpl();
		}
		return instance;
	}
	
	// 샘플 초기 데이터
	private void initData() {
		//Map<Long, Member>의 put
		memberStore.put(1L, new Member(1L, "홍길동", Grade.VIP)); // L은 접미사
		memberStore.put(2L, new Member(2L, "이몽룡", Grade.BASIC)); 
		memberStore.put(3L, new Member(3L, "성춘향", Grade.VIP)); 
	}
	
	
	@Override
	public void save(Member member) {
		// 회원 저장 기능
		memberStore.put(member.getId(), member);
		
	}

	@Override
	public Member findById(Long memberId) {
		return memberStore.get(memberId);
	}

}