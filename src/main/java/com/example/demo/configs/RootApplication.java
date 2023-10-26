package com.example.demo.configs;



import com.example.demo.models.Candidate;
import com.example.demo.models.Experience;
import com.example.demo.responsitories.CandidateRepository;
import com.example.demo.responsitories.ExperienceRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.io.IOException;

@WebServlet("/controller")
public class RootApplication extends HttpServlet {
    private CandidateRepository candidateRepository = new CandidateRepository();
    private ExperienceRepository experienceRepository = new ExperienceRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "candidate":
                handleCandidateRequest(req, resp);
                break;
            case "report":
                handleReportRequest(req, resp);
                break;
            case "report2":
                handleReport2Request(req,resp);
                break;
            case "candidateDetails":
                handleCandidateDetailRequest(req, resp);
                break;
            case "findCandidateByRole":
                handleFindCandidateByRoleRequest(req,resp);
        }
    }

    private void handleReport2Request(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("candidates", candidateRepository.findAll());
        req.getRequestDispatcher("report2.jsp").forward(req, resp);
    }

    private void handleFindCandidateByRoleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int selectedRole = Integer.parseInt(req.getParameter("role"));
        req.setAttribute("candidates", candidateRepository.findByRole(selectedRole));
        req.getRequestDispatcher("report.jsp").forward(req, resp);
    }

    private void handleReportRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("candidates", null);
        req.getRequestDispatcher("report.jsp").forward(req, resp);
    }

    public void handleCandidateRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("candidates", candidateRepository.findAll());
        req.getRequestDispatcher("candidate.jsp").forward(req, resp);
    }

    public void handleCandidateDetailRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long candidateId = Long.valueOf(req.getParameter("id"));
        req.setAttribute("candidate", candidateRepository.findById(candidateId));
        req.getRequestDispatcher("candidateDetails.jsp").forward(req, resp);
    }
}
