package com.sonpen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by sonikju on 2018-10-09.
 */
@RunWith(SpringRunner.class)
@DataMongoTest
public class MongoDbTest {

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void test() {
        Meeting meeting = new Meeting();
        meeting.setTitle("new title");
        meeting.setAddress("new address");
        mongoTemplate.save(meeting);

        Meeting meeting1 = new Meeting();
        meeting1.setTitle("old title");
        meeting1.setAddress("old address");
        mongoTemplate.save(meeting1);

        List<Meeting> result = mongoTemplate.findAll(Meeting.class);
        result.forEach(m -> System.out.println(m));

        assertThat(result.size()).isEqualTo(2);

        Query query = new Query();
        query.addCriteria(Criteria.where("title").is("old title"));
        Meeting m = mongoTemplate.findOne(query, Meeting.class);
        assertThat(m.getTitle()).isEqualTo(meeting1.getTitle());
    }

}
