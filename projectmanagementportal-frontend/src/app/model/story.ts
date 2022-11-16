export class Story{

    //  storyId!: string;
    //   projectId!: string;
    //   storyTitle!: string;
    //   storyDescription!: string;
    //   assignee!: string;
    //   assigneeEmailId!: string;
    //   assignmentDate!: Date;
    //   targetDate!: Date;
    //   status!: string;
    //   remarks!: string
  
  
    constructor(
  
      public storyId: string,
      public storyTitle: string,
      public storyDescription: string,
      public assignee: string,
      public assigneeEmailId: string,
      public assignmentDate: Date,
      public targetDate: Date,
      public status: string,
      public remarks: string,
      public projectIdName: string,
      public storyAssignedTo: string,
      public storyAssignedToUsers: string[]
    ) {}
  }