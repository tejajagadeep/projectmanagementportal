export class Project {
    // projectId!: string;
    // projectName!: string;
    // projectDescription!: string;
    // teamName!: string;
    // teamSize!: string;
    // projectManagerName!: string;
    // projectManagerEmailId!: string;
    // techLeadName!: string;
    // techLeadEmailId!: string;
    // projectStartDate!: Date;
    // projectEndDate!: Date;
    // techStack!: string;
    // status!: string;
    // remarks!: string;
    constructor(
  
      public projectId: string,
      public projectName: string,
      public projectDescription: string,
      public teamName: string,
      public teamSize: string,
      public projectManagerName: string,
      public projectManagerEmailId: string,
      public techLeadName: string,
      public techLeadEmailId: string,
      public projectStartDate: Date,
      public projectEndDate: Date,
      public techStack: string,
      public status: string,
      public remarks: string
  
    ) { }
  }