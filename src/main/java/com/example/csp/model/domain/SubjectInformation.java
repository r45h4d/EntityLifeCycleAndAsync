package com.example.csp.model.domain;

import org.springframework.stereotype.Component;

import java.util.HashMap;
@Component
public class SubjectInformation {
    Subject subject;
    StringBuffer purposeOfTeachingTheSubject;
    StringBuffer theMainTaskOfTeachingTheSubject;
    StringBuffer requirementsForSubjectKnowledgeAndSkills;

    HashMap theRelationshipOfTheSubjectWithOtherSubjects;
}
