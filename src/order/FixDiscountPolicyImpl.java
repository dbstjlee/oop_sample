package order;

import member.Grade;
import member.Member;

public class FixDiscountPolicyImpl implements DiscountPolicy {

	// 할인 고정 금액: 1500원
	private int discountFixAmount = 1500;
	
	@Override
	public int discount(Member member, int price) {
		// VIP 회원만 할인 금액 적용
		if(member.getGrade() == Grade.VIP) {
			return discountFixAmount;
		}
		return 0;
	}
}
