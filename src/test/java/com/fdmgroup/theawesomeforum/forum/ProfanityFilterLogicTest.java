package com.fdmgroup.theawesomeforum.forum;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.fdmgroup.theawesomeforum.forum.profanity.Profanity;
import com.fdmgroup.theawesomeforum.forum.profanity.ProfanityFilterLogic;

@RunWith(MockitoJUnitRunner.class)
public class ProfanityFilterLogicTest {

	private String stringWithProfanity;
	private String expectedString1;
	private String filteredString;
	private String expectedString2;
	private String stringWithProfanityWithUpperCase;
	private Profanity profanity1;
	private Profanity profanity2;
	private List<Profanity> testProfanityList;

	@Before
	public void setUpBeforeClass() {
		MockitoAnnotations.initMocks(this);
		stringWithProfanity = "the word profanity is forbidden";
		expectedString1 = "the word ***** is forbidden";
		expectedString2 = "no word is forbidden";
		stringWithProfanityWithUpperCase = "the word Profanity is forbidden";
		profanity1 = new Profanity("profanity");
		profanity2 = new Profanity("random");
		testProfanityList = new ArrayList<>();
		testProfanityList.add(profanity1);
		testProfanityList.add(profanity2);
	}

	@Test
	public void testFilterProfanitiesReturnChangedStringIfProfanityDetected() {
		filteredString = ProfanityFilterLogic.filterProfanities(stringWithProfanity, testProfanityList);
		assertEquals(expectedString1, filteredString);
	}

	@Test
	public void testFilterProfanitiesReturnSameStringIfNoProfanityDetected() {
		filteredString = ProfanityFilterLogic.filterProfanities(expectedString2, testProfanityList);
		assertEquals(expectedString2, filteredString);
	}

	@Test
	public void testFilterProfanitiesReturnChangedStringIfProfanityLowerAndUpperCaseSensitiveDetected() {
		filteredString = ProfanityFilterLogic.filterProfanities(stringWithProfanityWithUpperCase, testProfanityList);
		assertEquals(expectedString1, filteredString);
	}

}
