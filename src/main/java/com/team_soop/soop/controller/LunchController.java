package com.team_soop.soop.controller;

import com.team_soop.soop.aop.annotation.ParamsPrintAspect;
import com.team_soop.soop.dto.SaveLunchCommentReqDto;
import com.team_soop.soop.dto.SaveLunchReqDto;
import com.team_soop.soop.dto.UpdateLunchCommentReqDto;
import com.team_soop.soop.security.PrincipalUser;
import com.team_soop.soop.service.LunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lunch")
public class LunchController {

    @Autowired
    private LunchService lunchService;

    // 뭐먹지 게시물 등록
    @PostMapping("/save")
    public ResponseEntity<?> lunchSave(@RequestBody SaveLunchReqDto saveLunchReqDto) {
        lunchService.saveLunch(saveLunchReqDto);
        return ResponseEntity.ok(true);
    }

    // 뭐먹지 댓글 등록
    @PostMapping("/comment/save")
    public ResponseEntity<?> lunchCommentSave(@RequestBody SaveLunchCommentReqDto saveLunchCommentReqDto) {
        lunchService.saveLunchComment(saveLunchCommentReqDto);
        return ResponseEntity.ok(true);
    }

    // 뭐먹지 게시물 리스트
    @GetMapping("/search")
    public ResponseEntity<?> searchLunch() {
        return ResponseEntity.ok(lunchService.searchLunchList());
    }


    // 댓글 등록
    @PostMapping("/comment/search")
    public ResponseEntity<?> searchLunchComment(@RequestParam int detailLunchId) {
        return ResponseEntity.ok(lunchService.searchLunchComment1(detailLunchId));
    }

    // 댓글 수정
    @PutMapping("/comment/update")
    public ResponseEntity<?> updateLunchComment (@RequestBody UpdateLunchCommentReqDto updateLunchCommentReqDto) {
        lunchService.updateComment(updateLunchCommentReqDto);
        return ResponseEntity.ok(true);
    }

    // 댓글 삭제
    @DeleteMapping("/comment/delete/{commentId}")
    public ResponseEntity<?> deleteLunchComment (@PathVariable int commentId) {
        lunchService.deleteComment(commentId);
        return ResponseEntity.ok(true);
    }

    // 좋아요,추천 등록
    @PostMapping("/{lunchId}/like")
    public ResponseEntity<?> lunchLike(@PathVariable int lunchId) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUserId();
        lunchService.saveLunchLike(userId, lunchId);
        return ResponseEntity.ok(null);
    }

    // 좋아요,추천 상태
    @GetMapping("/{lunchId}/like")
    public ResponseEntity<?> getLunchLike(@PathVariable int lunchId) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUserId();

        return ResponseEntity.ok(lunchService.getLikeStatus(userId, lunchId));
    }

    // 좋아요,추천 취소
    @DeleteMapping("/{lunchId}/like")
    public ResponseEntity<?> lunchUnLike(@PathVariable int lunchId) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principalUser.getUserId();
        lunchService.unLikeLunch(userId, lunchId);
        return ResponseEntity.ok(null);
    }






}
