import { Project } from "./project";

export class User {

  // userId!: string;
  //   name!: string;
  //   emailAddress!: string;
  //   contactNo!: number;
  //   dateOfBirth!: string;
  //   userType!: string;
  //   password!: string;
  constructor(

    // public userId: string,
    public userName: string,
    public name: string,
    public emailAddress: string,
    public contactNo: number,
    public dateOfBirth: Date,
    public role: string,
    public password: string,
    public projects: Project[]
  ) { }
}