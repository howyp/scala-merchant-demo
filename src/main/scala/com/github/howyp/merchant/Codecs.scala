package com.github.howyp.merchant

import io.circe.{Decoder, Encoder, Json}
import io.circe.syntax._
import io.circe.generic.auto._
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.generic.extras.semiauto.{deriveEnumerationDecoder, deriveEnumerationEncoder}
import io.circe.java8.time.{decodeZonedDateTimeDefault, encodeZonedDateTimeDefault}
import org.http4s.Uri

object Codecs {
  implicit val currencyAmountDecoder: Decoder[Currency] = deriveEnumerationDecoder[Currency]
  implicit val currencyAmountEncoder: Encoder[Currency] = deriveEnumerationEncoder[Currency]

  implicit val offerDecoder: Decoder[Offer.Valid] = deriveDecoder[Offer.Valid]
  implicit val offerEncoder: Encoder[Offer.Valid] = deriveEncoder[Offer.Valid]

  def collectionWithHref[Key, Item](uri: Key => Uri)(implicit keyEnc: Encoder[Uri],
                                                     itemEnc: Encoder[Item]): Encoder[Map[Key, Item]] =
    Encoder[Iterable[Json]].contramap(_.map {
      case (id, item) => Json.obj("href" -> uri(id).asJson, "item" -> item.asJson)
    })
}
