const express = require("express");
const app = express();
app.use(express.json());

let courses = [

    {
        id: 1,
        courseName: "Web Development",
        duration: "6 Months"
    },

    {
        id: 2,
        courseName: "Machine Learning",
        duration: "8 Months"
    }

];

let students = [

    {
        id: 1,
        studentName: "Rahul",
        courseId: 1
    },

    {
        id: 2,
        studentName: "Priya",
        courseId: 2
    }

];

app.get("/courses", (req, res) => {

    res.json(courses);

});

app.get("/courses/:id", (req, res) => {

    const id = Number(req.params.id);

    const course =
        courses.find(c => c.id === id);

    if (!course) {

        return res.status(404).json({
            message: "Course not found"
        });
    }

    res.json(course);

});

app.post("/courses", (req, res) => {

    const newCourse = {

        id: courses.length + 1,

        courseName: req.body.courseName,

        duration: req.body.duration
    };

    courses.push(newCourse);

    res.status(201).json({
        message: "Course Added",
        course: newCourse
    });

});

app.put("/courses/:id", (req, res) => {

    const id = Number(req.params.id);

    const course =
        courses.find(c => c.id === id);

    if (!course) {

        return res.status(404).json({
            message: "Course not found"
        });
    }

    course.courseName =
        req.body.courseName;

    course.duration =
        req.body.duration;

    res.json({
        message: "Course Updated",
        course
    });

});

app.delete("/courses/:id", (req, res) => {

    const id = Number(req.params.id);

    courses =
        courses.filter(c => c.id !== id);

    res.json({
        message: "Course Deleted"
    });

});

app.get("/students", (req, res) => {

    res.json(students);

});

app.get("/students/:id", (req, res) => {

    const id = Number(req.params.id);

    const student =
        students.find(s => s.id === id);

    if (!student) {

        return res.status(404).json({
            message: "Student not found"
        });
    }

    res.json(student);

});

app.post("/students", (req, res) => {

    const newStudent = {

        id: students.length + 1,

        studentName: req.body.studentName,

        courseId: req.body.courseId
    };

    students.push(newStudent);

    res.status(201).json({
        message: "Student Added",
        student: newStudent
    });

});

app.put("/students/:id", (req, res) => {

    const id = Number(req.params.id);

    const student =
        students.find(s => s.id === id);

    if (!student) {

        return res.status(404).json({
            message: "Student not found"
        });
    }

    student.studentName =
        req.body.studentName;

    student.courseId =
        req.body.courseId;

    res.json({
        message: "Student Updated",
        student
    });

});

app.delete("/students/:id", (req, res) => {

    const id = Number(req.params.id);

    students =
        students.filter(s => s.id !== id);

    res.json({
        message: "Student Deleted"
    });

});

app.listen(5000, () => {

    console.log(
        "Server running on port 5000"
    );

});