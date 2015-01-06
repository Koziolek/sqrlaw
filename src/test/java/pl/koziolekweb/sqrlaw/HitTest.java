package pl.koziolekweb.sqrlaw;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class HitTest {

	private Hit sut;

	@BeforeMethod
	public void setUp() throws Exception {
		sut = new Hit(4);
	}

	@Test
	public void shouldToWoundBe4() {
		// when
		int wound = sut.toWound(4);
		// then
		assertThat(wound).isEqualTo(4);
	}

	@Test
	public void shouldToWoundBe3() {
		// when
		int wound = sut.toWound(3);
		// then
		assertThat(wound).isEqualTo(3);
	}

	@Test
	public void shouldToWoundBe2() {
		// when
		int wound = sut.toWound(2);
		// then
		assertThat(wound).isEqualTo(2);
	}

	@Test
	public void shouldToWoundBe5() {
		// when
		int wound = sut.toWound(5);
		// then
		assertThat(wound).isEqualTo(5);
	}

	@Test
	public void shouldToWoundBe6() {
		// when
		int wound = sut.toWound(6);
		// then
		assertThat(wound).isEqualTo(6);
	}

	@Test
	public void shouldToWoundBe7() {
		// when
		int wound = sut.toWound(8);
		// then
		assertThat(wound).isEqualTo(7);
	}
}