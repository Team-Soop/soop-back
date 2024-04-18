package com.team_soop.soop.repository;

import com.team_soop.soop.entity.Feed;
import com.team_soop.soop.entity.FeedLike;
import com.team_soop.soop.entity.FeedList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.yaml.snakeyaml.events.Event;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@Mapper
public interface FeedMapper {

    public int saveFeed(Feed feed);
    public int saveFeedImgUrl(@Param("feedId") int feedId, @Param("feedImgUrls") List<String> feedImgUrls);
    public List<FeedList> searchFeeds();
    public int saveFeedLike(FeedLike feedLike);
}
